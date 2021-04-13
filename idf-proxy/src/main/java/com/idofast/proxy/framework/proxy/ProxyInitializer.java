package com.idofast.proxy.framework.proxy;

import com.idofast.proxy.bean.RemoteConst;
import com.idofast.proxy.framework.proxy.handler.ParserHandler;
import com.idofast.proxy.framework.service.AccountService;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;


/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/13 11:03 下午
 */
public class ProxyInitializer extends ChannelInitializer<SocketChannel>
{

    private final AccountService accountService;
    private final RemoteConst remoteConst;

    public ProxyInitializer(AccountService accountService, RemoteConst remoteConst)
    {
        this.accountService = accountService;
        this.remoteConst = remoteConst;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ch.pipeline().addLast(
                new ParserHandler(accountService, remoteConst));
    }
}