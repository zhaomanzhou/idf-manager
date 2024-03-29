package com.idofast.common.response;



import java.io.Serializable;

//@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;


    public ServerResponse()
    {
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }




    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }


    public static <T> ServerResponse<T> success() {
        return new ServerResponse<T>(BaseResponseCode.SUCCESS.getCode(), null);
    }



    public static <T> ServerResponse<T> success(T data) {
        return new ServerResponse<T>(BaseResponseCode.SUCCESS.getCode(), "success", data);
    }




    public static <T> ServerResponse<T> error() {
        return new ServerResponse<T>(BaseResponseCode.ERROR.getCode(), "error");
    }


    public static <T> ServerResponse<T> error(String errorMessage) {
        return new ServerResponse<T>(BaseResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> ServerResponse<T> error(int status, String errorMessage) {
        return new ServerResponse<T>(status, errorMessage);
    }


    public void setStatus(int status)
    {
        this.status = status;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public void setData(T data)
    {
        this.data = data;
    }


}