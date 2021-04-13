package com.idofast.proxy.framework.proxy;


import com.idofast.proxy.bean.RemoteConst;
import com.idofast.proxy.framework.service.AccountService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;

/**
 * a proxyServer starter
 */
@Slf4j
@Component
public final class ProxyServer
{


    @Autowired
    private AccountService accountService;

    @Autowired
    private RemoteConst remoteConst;

    @Value("${proxy.netty.port}")
    private Integer port;


    private static EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    private static EventLoopGroup workerGroup = new NioEventLoopGroup();

    @PostConstruct
    public void initNettyServer() {


        // Configure the bootstrap.
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.option(ChannelOption.SO_BACKLOG, 1024)
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);


            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ProxyInitializer(accountService, remoteConst))
                    .childOption(ChannelOption.AUTO_READ, false)
                    .bind(port)
                    .addListener((ChannelFutureListener) future -> log.info("Proxying on:" + port + " ..."));


        } catch (Exception e) {
            log.error("netty start exception:", e);
        }
    }


    @PreDestroy
    public void preDestroy() throws InterruptedException {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully().addListener(future -> {
            log.warn("ReportService 已经关闭....");
//            TaskService.destroy();
        });
        workerGroup.awaitTermination(3, TimeUnit.SECONDS);
        log.warn("netty 已经关闭....");


    }
}
