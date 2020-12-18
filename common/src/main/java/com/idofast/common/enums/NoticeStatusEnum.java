package com.idofast.common.enums;

public enum NoticeStatusEnum
{
    DRAFT(0, "未发布"),
    PUBLISHED(1, "已发布"),
    DOWN(2, "下架"),

    ;
    private int code;
    private String message;

    NoticeStatusEnum(int code, String message)
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

    public static NoticeStatusEnum codeOf(Integer code)
    {
        switch (code)
        {
            case 0: return DRAFT;
            case 1: return PUBLISHED;
            case 2: return DOWN;
        }
        return null;
    }
}
