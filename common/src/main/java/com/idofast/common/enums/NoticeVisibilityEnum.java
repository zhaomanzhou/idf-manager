package com.idofast.common.enums;

public enum NoticeVisibilityEnum
{
    ALL(0, "所有人可见"),
    USER(1, "所有注册用户可见"),
    ADMIN(2,"只有管理员可见")
    ;
    private int code;
    private String message;

    NoticeVisibilityEnum(int code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public int getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }

    public static NoticeVisibilityEnum codeOf(Integer code)
    {
        switch (code)
        {
            case 0: return ALL;
            case 1: return USER;
            case 2: return ADMIN;
        }
        return null;
    }
}
