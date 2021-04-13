package com.idofast.proxy.util;

import com.idofast.proxy.bean.ProxyConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 3:44 下午
 */
@Component
public class UrlUtil
{
    @Autowired
    private ProxyConstant proxyConstant;

    private String prefix;

    private Object lock = new Object();


    public String getProxyInfoUrl()
    {
        if(proxyConstant.getGetProxyInfoUrl().startsWith("/"))
        {
            return genPrefix() + proxyConstant.getGetProxyInfoUrl();
        }else
        {
            return genPrefix() + "/" + proxyConstant.getGetProxyInfoUrl();
        }
    }


    private String genPrefix()
    {
        if (prefix == null)
        {
            synchronized (lock)
            {
                if (prefix == null)
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append("http");
                    if (proxyConstant.getTls())
                    {
                        sb.append("s");
                    }
                    sb.append("://");
                    sb.append(proxyConstant.getHost());
                    if (proxyConstant.getPort() != 80)
                    {
                        sb.append(":").append(proxyConstant.getPort());
                    }
                    prefix = sb.toString();
                }

            }
        }
        return prefix;
    }
}
