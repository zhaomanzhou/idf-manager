package com.idofast.common.enums;

public enum RoleEnum implements IBaseEnum {
    ADMIN(0, "admin"),
    PLAIN(1,"user");

    RoleEnum(int code, String value)
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

    public static RoleEnum ofCode(int code)
    {
        switch (code)
        {
            case 0: return ADMIN;
            case 1: return PLAIN;
            default:throw new IllegalArgumentException("非法的role code");
        }
    }
}