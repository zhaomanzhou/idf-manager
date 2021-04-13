package com.idofast.proxy.framework.proxy.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ForwardHandler extends ChannelInboundHandlerAdapter
{

    private final ParserHandler parserHandler;

    public ForwardHandler(ParserHandler parserHandler) {
        this.parserHandler = parserHandler;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        ctx.channel().read();
    }

    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) {
        parserHandler.getChannel().writeAndFlush(msg).addListener((ChannelFutureListener) future -> {
            if (!future.isSuccess()) {
                release((ByteBuf) msg);
                log.error("-----------v2ray服务端数据回写失败------------");
                parserHandler.close();
            }else
            {
                ctx.channel().read();
            }
        });


    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        parserHandler.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error(" Receiver exceptionCaught: {}", cause.getMessage());
        parserHandler.close();

    }


    public void release(ByteBuf byteBuf)
    {
        if(ReferenceCountUtil.refCnt(byteBuf) > 0)
        {
            ReferenceCountUtil.release(byteBuf);
        }
    }


}

