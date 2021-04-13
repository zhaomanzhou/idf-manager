package com.idofast.proxy.framework.proxy.handler;

import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.response.error.BusinessException;
import com.idofast.proxy.bean.RemoteConst;
import com.idofast.proxy.framework.service.AccountService;
import com.idofast.proxy.util.NettyClientFactory;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.traffic.GlobalTrafficShapingHandler;
import io.netty.handler.traffic.TrafficCounter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 12:00 下午
 */
@Slf4j
public class ParserHandler extends ChannelInboundHandlerAdapter
{

    private boolean isHandshaking = true;
    private AccountService accountService;
    private V2rayAccountDto accountDto;
    private RemoteConst remoteConst;


    private Channel outboundChannel;
    private ChannelHandlerContext ctx;

    private GlobalTrafficShapingHandler trafficShapingHandler;


    static AtomicLong total = new AtomicLong(0);
    private volatile boolean closed = false;


    public ParserHandler(AccountService accountService, RemoteConst remoteConst)
    {
        this.accountService = accountService;
        this.remoteConst = remoteConst;
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception
    {
        if(outboundChannel != null)
        {
            closeOnFlush(outboundChannel);
        }

        if (trafficShapingHandler != null)
        {
            TrafficCounter trafficCounter = trafficShapingHandler.trafficCounter();
            long writtenBytes = trafficCounter.cumulativeWrittenBytes();
            long readBytes = trafficCounter.cumulativeReadBytes();
            log.info("账号:{},当前服务器完全断开连接,累计字节:{} KB", accountDto.getEmail(), (writtenBytes + readBytes) >> 10);
            log.info("总流量：{}MB", total.addAndGet(writtenBytes + readBytes) >> 10 >> 10);
        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
    {

        if (isHandshaking)
        {
            try
            {
                parserUser(ctx, msg);
                attachTrafficController(ctx, accountDto);
                connectToClient(ctx, (ByteBuf) msg, ctx.channel());
            } catch (Exception e)
            {

                log.warn("解析用户或连接v2ray发生异常, {}", e.getMessage());
                ReferenceCountUtil.release(msg);
                ctx.channel().close();
                return;
            }

            isHandshaking = false;
            return;
        }
        writeToOutBoundChannel(msg, ctx);

    }

    /**
     * 为channel 增加对应的TrafficController
     *
     * @param ctx ChannelHandlerContext
     */
    private void attachTrafficController(ChannelHandlerContext ctx, V2rayAccountDto accountDto)
    {
        trafficShapingHandler = new GlobalTrafficShapingHandler(ctx.executor());
        ctx.pipeline().addFirst(trafficShapingHandler);
    }


    private void connectToClient(ChannelHandlerContext ctx, final ByteBuf handshakeByteBuf, Channel inboundChannel)
    {
        Bootstrap client = NettyClientFactory.getClient(inboundChannel.eventLoop());
        ChannelFuture f = client.connect(remoteConst.getV2rayHost(), remoteConst.getV2rayPort());
        outboundChannel = f.channel();
        outboundChannel.pipeline().addLast(new ForwardHandler(ctx.channel()));

        f.addListener(future -> {
            if (!future.isSuccess())
            {
                future.cause().printStackTrace();
                System.out.println("与v2ray连接失败");
                ctx.channel().close();
            } else
            {
                writeToOutBoundChannel(handshakeByteBuf, ctx);
            }
        });

    }

    private void writeToOutBoundChannel(Object msg, final ChannelHandlerContext ctx)
    {
        outboundChannel.writeAndFlush(msg).addListener((ChannelFutureListener) future -> {
            if (!future.isSuccess())
            {
                log.info("channel1 写入数据失败");
                future.channel().close();
            } else
            {
                ctx.channel().read();
            }
        });
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        cause.printStackTrace();
        log.warn("连接发生异常exceptionCaught....{}", cause.getMessage());
        closeOnFlush(ctx.channel());
    }


    /**
     * 通过http头部解析用户信息，并返回去除掉用户信息的数据
     */
    private void parserUser(ChannelHandlerContext ctx, Object msg) throws BusinessException
    {
        ByteBuf byteBuf = ((ByteBuf) msg);
        String httpHead = byteBuf.toString(Charset.defaultCharset());
        int endIndex = httpHead.indexOf("HTTP");
        String id = httpHead.substring(8, endIndex).trim();
        accountDto = accountService.getAndSynchUserById(Long.parseLong(id));
        if (accountDto == null)
        {
            throw new BusinessException("获取用户失败");
        }
        String replace = httpHead.replace(id, "");
        byteBuf.clear().writeBytes(replace.getBytes());
    }

    public void release(ByteBuf buf)
    {
        if (ReferenceCountUtil.refCnt(buf) > 0)
        {
            ReferenceCountUtil.safeRelease(buf);
        }
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        this.ctx = ctx;
        ctx.channel().read();
    }

    public Channel getChannel()
    {
        return this.ctx.channel();
    }

    public void close()
    {
        if (!closed)
        {
            closed = true;
            if (outboundChannel != null)
            {
                outboundChannel.close().addListener(f -> {
                    if (!f.isSuccess())
                    {
                        log.warn("Channel2 关闭失败, 失败原因。。。");
                        log.warn(f.cause().getLocalizedMessage());
                    }
                });
            }

            ctx.close().addListener(f -> {
                if (!f.isSuccess())
                {
                    log.warn("Channel2 关闭失败, 失败原因。。。");
                    log.warn(f.cause().getLocalizedMessage());
                }
            });

        }
    }


    static void closeOnFlush(Channel ch) {
        if (ch.isActive()) {
            ch.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        }
    }

}
