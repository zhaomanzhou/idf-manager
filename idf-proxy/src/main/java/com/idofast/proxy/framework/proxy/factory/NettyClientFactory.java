package com.idofast.proxy.framework.proxy.factory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 11:04 下午
 */
public  class NettyClientFactory
{
    private static Bootstrap b = null;

    public static Bootstrap getClient(EventLoop eventLoop)
    {
        if (b != null)
        {
            return b;
        }
        synchronized (NettyClientFactory.class)
        {
            if (b != null)
            {
                return b;
            }
            b = new Bootstrap();
            b.group(eventLoop)
                    .channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>()
            {

                @Override
                protected void initChannel(SocketChannel ch)
                {
                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter());
                }
            })
                    .option(ChannelOption.AUTO_READ, false);
        }
        return b;

    }
}
