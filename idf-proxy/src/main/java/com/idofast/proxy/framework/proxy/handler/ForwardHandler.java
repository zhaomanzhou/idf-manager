package com.idofast.proxy.framework.proxy.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ForwardHandler extends ChannelInboundHandlerAdapter
{

    private final Channel inboundChannel;

    public ForwardHandler(Channel inboundChannel)
    {
        this.inboundChannel = inboundChannel;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        ctx.read();
    }

    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) {
        inboundChannel.writeAndFlush(msg).addListener((ChannelFutureListener) future -> {
            if (!future.isSuccess()) {
                future.channel().close();
            }else
            {
                ctx.channel().read();
            }
        });


    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        ParserHandler.closeOnFlush(inboundChannel);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error(" Receiver exceptionCaught: {}", cause.getMessage());
        ParserHandler.closeOnFlush(inboundChannel);
    }





}

