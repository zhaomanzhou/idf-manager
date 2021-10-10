package com.idofast.common.response.exception;

public interface CommonError
{
    int getErrorCode();
    String getErrorMessage();
    CommonError setErrorMessage(String errorMessage);
}
