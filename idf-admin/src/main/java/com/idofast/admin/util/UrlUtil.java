package com.idofast.admin.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/14 7:39 下午
 */
@Component
public class UrlUtil
{
    @Value("${proxy.api.rmAccount}")
    private String apiUrl;

    @Value("${proxy.port}")
    private String port;

    @Value("${proxy.tls}")
    private Boolean tls;

    @PostConstruct
    public void init()
    {
        if(!apiUrl.startsWith("/"))
        {
            apiUrl = "/" + apiUrl;
        }
    }

    public String getRmAccountUrl(String host)
    {
        if(!tls)
            return "http://" + host + ":" + port + apiUrl;
        else
            return "https://" + host + ":" + port + apiUrl;

    }
}
