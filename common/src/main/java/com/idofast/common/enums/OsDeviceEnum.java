package com.idofast.common.enums;

public enum OsDeviceEnum
{
    ANDROID(0b01, "安卓"),
    IOS(0b010, "IOS"),
    WIN10(0b0100, "win10"),
    WIN7(0b01000, "win7"),
    MAC(0b010000, "苹果电脑");

    private int code;
    private String value;

    OsDeviceEnum(int code, String value)
    {
        this.code = code;
        this.value = value;
    }

    public int getCode()
    {
        return code;
    }

    public String getValue()
    {
        return value;
    }
}
