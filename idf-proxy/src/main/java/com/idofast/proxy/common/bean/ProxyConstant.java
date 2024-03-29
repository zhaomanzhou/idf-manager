package com.idofast.proxy.common.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhaomanzhou
 * @version 1.0
 *
 * master服务器信息
 * @createTime 2021/4/12 2:41 下午
 */
@Component
@ConfigurationProperties(prefix = "proxy.master")
@Data
@Slf4j
public class ProxyConstant
{

    private String authPassword;
    private String getProxyInfoUrl;
    private String reportStateUrl;
    private String host;
    private Integer port;
    private Boolean tls;

}
