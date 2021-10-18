package com.idofast.proxy.transport.proxy.factory;

import com.idofast.proxy.common.bean.V2rayServiceConst;
import com.idofast.proxy.transport.proxy.handler.ParserHandler;
import com.idofast.proxy.biz.service.AccountService;
import com.idofast.proxy.biz.service.UserReportService;
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
    private final V2rayServiceConst v2rayServiceConst;

    public ProxyInitializer(AccountService accountService, UserReportService userReportService, V2rayServiceConst v2rayServiceConst)
    {
        this.accountService = accountService;
        this.userReportService = userReportService;
        this.v2rayServiceConst = v2rayServiceConst;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ch.pipeline().addLast(
                new ParserHandler(accountService, userReportService, v2rayServiceConst));
    }
}