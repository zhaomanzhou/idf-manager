package com.idofast.admin.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

    public String getRmAccountUrl(String host)
    {
        return "http://" + host + ":" + port + apiUrl;
    }
}
