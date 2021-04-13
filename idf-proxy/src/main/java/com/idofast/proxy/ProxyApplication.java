package com.idofast.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 1:32 下午
 */
@SpringBootApplication
public class ProxyApplication
{
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //需要接受args，如果不加载不了自定义配置
        SpringApplication.run(ProxyApplication.class,args);
    }
}
