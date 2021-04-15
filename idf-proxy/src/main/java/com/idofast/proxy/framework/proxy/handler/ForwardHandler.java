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
    private final ParserHandler parserHandler;

    public ForwardHandler(ParserHandler parserHandler, Channel inboundChannel)
    {
        this.parserHandler = parserHandler;
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





}

