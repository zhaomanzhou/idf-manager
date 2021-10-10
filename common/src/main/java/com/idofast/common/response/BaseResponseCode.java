package com.idofast.common.response;



public enum BaseResponseCode
{

    SUCCESS(200,"SUCCESS"),
    ERROR(5000,"ERROR");

    private final int code;
    private final String desc;


    BaseResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
