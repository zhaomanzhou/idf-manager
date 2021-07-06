package com.idofast.admin.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/3 9:53 下午
 */

@Data
@Component
@ConfigurationProperties(prefix = "alipay")
public class AlipayProperties
{
    private String signType = "RSA2";
    private String protocol;
    private String appId;
    private String gatewayHost;
    private String merchantPrivateKey;
    private String alipayPublicKey;
    private String notifyUrl;


}
