package com.idofast.common.redis;


public class RedisPrefixConst {
    public static String TOKEN_PREFIX = "token-";

    public static String withTokenPrefix(String token)
    {
        return TOKEN_PREFIX + token;
    }
}
