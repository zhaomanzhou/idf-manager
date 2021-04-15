package com.idofast.admin.domain.dto;

import com.idofast.admin.domain.User;
import com.idofast.admin.domain.UserProxyInfo;
import lombok.Data;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/15 12:48 上午
 */
@Data
public class OnlineUserDto
{
    private Long id;
    private User user;
    private UserProxyInfo proxyInfo;
    private String serverHost;
    private Integer connectionNum;

}
