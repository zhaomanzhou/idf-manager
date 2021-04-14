package com.idofast.proxy.framework.proxy.handler;

import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.response.error.BusinessException;
import com.idofast.proxy.bean.RemoteConst;
import com.idofast.proxy.framework.service.AccountService;
import com.idofast.proxy.framework.proxy.factory.NettyClientFactory;
import com.idofast.proxy.framework.service.UserReportService;
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
    private UserReportService userReportService;
    private V2rayAccountDto accountDto;
    private RemoteConst remoteConst;


    private Channel outboundChannel;

    private GlobalTrafficShapingHandler trafficShapingHandler;


    static AtomicLong total = new AtomicLong(0);


    public ParserHandler(AccountService accountService, UserReportService userReportService,RemoteConst remoteConst)
    {
        this.accountService = accountService;
        this.userReportService = userReportService;
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
            userReportService.addUsedData(accountDto.getId(), (writtenBytes + readBytes) >> 10 + 1);
            if(!isHandshaking)
            {
                int i = userReportService.decreaseConnectionNum(accountDto.getId());
                log.info("账号:{},断开一个连接,累计字节:{} KB，目前连接数{}", accountDto.getEmail(), (writtenBytes + readBytes) >> 10,i);
            }

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

            int i = userReportService.addConnectionNum(accountDto.getId());
            log.info("账号{}已连接, 连接数{}", accountDto.getEmail(), i);
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
                log.info("与v2ray连接失败", future.cause());
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
        String replace = httpHead.replace(id, "");
        byteBuf.clear().writeBytes(replace.getBytes());
    }



    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        ctx.channel().read();
    }




    static void closeOnFlush(Channel ch) {
        if (ch.isActive()) {
            ch.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        }
    }

}
