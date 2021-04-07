package com.idofast.admin.domain.enums;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/4 11:46 下午
 */
public enum SystemPreferenceKeyEnum
{
    //空闲使用时间,单位 分钟， 类型  int
    FREE_USER_TIME("FREE_USER_TIME", 60*24 + "" ),
    // 流量重置天数， 单位 天， 类型 int
    DATA_RESET_PERIOD("DATA_RESET_PERIOD", 30 + "");

    SystemPreferenceKeyEnum(String key, String defaultValue)
    {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    private String key;

    private String defaultValue;


    public String getKey()
    {
        return key;
    }

    public String getDefaultValue()
    {
        return defaultValue;
    }
}
