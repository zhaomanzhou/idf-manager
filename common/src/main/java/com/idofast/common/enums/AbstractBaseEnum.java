package com.idofast.common.enums;

public abstract class AbstractBaseEnum implements IBaseEnum
{
    protected Integer code;
    protected String value;

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
