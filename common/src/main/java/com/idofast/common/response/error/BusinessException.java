package com.idofast.common.response.error;


import com.idofast.common.common.ResponseCode;

//包装器业务异常实现
public class BusinessException extends Exception implements CommonError
{

    private CommonError commonError;


    public BusinessException(CommonError commonError)
    {
        super();
        this.commonError = commonError;
    }


    //接收自定义errormessage的方式构造异常
    public BusinessException(CommonError commonError, String errorMessage)
    {
        super();
        this.commonError = commonError;
        this.commonError.setErrorMessage(errorMessage);
    }


    public BusinessException(String message)
    {
        super();
        this.commonError = new CommonErrorAdapter(ResponseCode.ERROR.getCode(), message);
    }

    @Override
    public int getErrorCode()
    {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMessage()
    {
        return this.commonError.getErrorMessage();
    }

    @Override
    public CommonError setErrorMessage(String errorMessage)
    {
        this.commonError.setErrorMessage(errorMessage);
        return this;
    }
}
