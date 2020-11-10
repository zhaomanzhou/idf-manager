package com.idofast.common.enums;

public enum  DeletedEnum
{
    NORMAL(0),
    DELETED(1);

    private int code;

    DeletedEnum(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }

    public static DeletedEnum ofCode(int code)
    {
        switch (code)
        {
            case 0: return NORMAL;
            case 1: return DELETED;
            default:throw new IllegalArgumentException("deleted statuscode");
        }
    }
}
