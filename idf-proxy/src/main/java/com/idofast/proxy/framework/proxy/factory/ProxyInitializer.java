package com.idofast.proxy.framework.proxy.factory;

import com.idofast.proxy.bean.RemoteConst;
import com.idofast.proxy.framework.proxy.handler.ParserHandler;
import com.idofast.proxy.framework.service.AccountService;
import com.idofast.proxy.framework.service.UserReportService;
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
    private final UserReportService userReportService;
    private final RemoteConst remoteConst;

    public ProxyInitializer(AccountService accountService, UserReportService userReportService, RemoteConst remoteConst)
    {
        this.accountService = accountService;
        this.userReportService = userReportService;
        this.remoteConst = remoteConst;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ch.pipeline().addLast(
                new ParserHandler(accountService, userReportService,remoteConst));
    }
}