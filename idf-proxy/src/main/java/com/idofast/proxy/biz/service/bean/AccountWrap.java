package com.idofast.proxy.biz.service.bean;

import com.idofast.common.dto.V2rayAccountDto;

import java.time.LocalDateTime;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/9/25 2:28 下午
 */
public class AccountWrap
{
    private V2rayAccountDto v2rayAccountDto;

    //上次从服务器获取的最新时间
    private LocalDateTime lastUpdateTimeFromRemote;

    //上次调用GRPC添加v2ray账户时间
    private LocalDateTime lastv2rayGrpcAddTime;


}
