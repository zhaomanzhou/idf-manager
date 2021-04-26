package com.idofast.proxy.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 10:36 下午
 */
@Component
@Data
public class RemoteConst
{
    @Value("${proxy.v2ray.host}")
    private String v2rayHost;

    @Value("${proxy.v2ray.port}")
    private Integer v2rayPort;

    @Value("${proxy.v2ray.wsPath}")
    private String wsPath;
}
