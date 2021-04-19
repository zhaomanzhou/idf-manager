package com.idofast.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 1:32 下午
 */
@SpringBootApplication
@Slf4j
public class ProxyApplication implements CommandLineRunner
{
    @Value("${proxy.local.host}")
    private String localHost;

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //需要接受args，如果不加载不了自定义配置
        SpringApplication.run(ProxyApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        log.info("当前服务器名称:{}", localHost);
    }
}
