package com.idofast.common.enums;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/17 11:33 下午
 */
public enum  ServerRegionEnum
{

    US("美国"),
    HK("香港"),
    JP("日本"),
    KR("韩国"),
    SA("南非"),
    ;

    private String name;

    ServerRegionEnum(String name)
    {
        this.name = name;
    }
}
