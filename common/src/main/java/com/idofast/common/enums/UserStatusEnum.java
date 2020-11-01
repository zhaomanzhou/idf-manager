package com.idofast.common.enums;

public enum  UserStatusEnum
{
    NORMAL(0, "正常"),
    FORBIDDEN(1, "封禁");

    UserStatusEnum(int code, String value)
    {
        this.code = code;
        this.value = value;
    }

    private int code;
    private String value;

    public Integer getCode()
    {
        return this.code;
    }


    public String getValue()
    {
        return this.value;
    }

    public static UserStatusEnum ofCode(int code)
    {
        switch (code)
        {
            case 0: return NORMAL;
            case 1: return FORBIDDEN;
            default:throw new IllegalArgumentException("非法的user statuscode");
        }
    }
}
