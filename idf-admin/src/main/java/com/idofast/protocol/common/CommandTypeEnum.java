package com.idofast.protocol.common;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/9/12 9:52 下午
 */
public enum  CommandTypeEnum
{
    ECHO(0, "echo测试");
    public int code;
    public String desc;

    CommandTypeEnum(int code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    CommandTypeEnum()
    {
    }
}
