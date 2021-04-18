package com.idofast.admin.controller.vo.response;

import com.idofast.admin.domain.User;
import lombok.Data;

import java.util.List;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/18 6:47 下午
 */
@Data
public class ServerBasedOnlineStatus
{
    private String host;
    private String name;
    private List<UserWithConnectionNum> users;
    @Data
    public static class UserWithConnectionNum extends User{
        private Integer connectionNum;
    }

}


