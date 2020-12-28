package com.idofast.common.enums;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2020/12/19 12:43 下午
 *
 * 公告类型
 */

public enum  NoticeTypeEnum
{


    INSTRUCTION(0, "安装教程"),  //教程
    NOTIFICATION(1, "通知公告"), //通知
    KNOWLEDGE(2, "科普"),       //科普
    ;
    private int code;
    private String message;

    NoticeTypeEnum(int code, String message)
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

    public static NoticeTypeEnum codeOf(Integer code)
    {
        switch (code)
        {
            case 0: return INSTRUCTION;
            case 1: return NOTIFICATION;
            case 2: return KNOWLEDGE;
        }
        return null;
    }
}
