package com.idofast.common.enums;

public enum EmailTypeEnum implements IBaseEnum
{
    REGISTER_VCODE(1, "注册验证码"),
    ACCOUNT_EXPIRE(2, "帐号过期提醒");


    protected Integer code;
    protected String value;

    EmailTypeEnum(Integer code, String value)
    {
        this.code = code;
        this.value = value;
    }

    @Override
    public Integer getCode()
    {
        return this.code;
    }

    @Override
    public String getValue()
    {
        return this.value;
    }


}
