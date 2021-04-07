package com.idofast.common.enums;

import com.idofast.common.enums.base.BaseAttributeConvert;
import com.idofast.common.enums.base.IBaseEnum;

import java.util.ArrayList;
import java.util.List;

//采用bitmap来实现， code代表bitmap的下标
public enum OsDeviceEnum implements IBaseEnum<OsDeviceEnum>
{
    ANDROID(1, "安卓"),
    IOS(2, "IOS"),
    WIN10(3, "win10"),
    WIN7(4, "win7"),
    MAC(5, "苹果电脑");

    OsDeviceEnum(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    //
    private final Integer code;
    private final String msg;

    @Override
    public Integer getCode()
    {
        return code;
    }

    @Override
    public String getMsg()
    {
        return msg;
    }


    public static OsDeviceEnum ofCode(Integer code){
        return (OsDeviceEnum) IBaseEnum.ofCodeII(code, OsDeviceEnum.class);
    }

    public static OsDeviceEnum ofMsg(String msg){
        OsDeviceEnum[] values = OsDeviceEnum.values();
        for (OsDeviceEnum deviceEnum: values)
        {
            if(deviceEnum.msg.equals(msg))
            {
                return deviceEnum;
            }
        }

        return null;
    }

    public static class Converter extends BaseAttributeConvert<OsDeviceEnum>
    {
        public Converter(){
            super(OsDeviceEnum.class);
        }
    }



    public static List<String> convertToStringList(Integer osDevice)
    {
        List<String> deviceList = new ArrayList<>();
        OsDeviceEnum[] values = OsDeviceEnum.values();
        for (OsDeviceEnum deviceEnum: values)
        {
            int bitIndex = deviceEnum.getCode();

            if((osDevice >> bitIndex & 0b01) == 0b01)
            {
                deviceList.add(deviceEnum.getMsg());
            }
        }

        return deviceList;

    }

    public static Integer addDevice(Integer osDevice, OsDeviceEnum osDeviceEnum)
    {
        return osDevice | 1 << osDeviceEnum.getCode();
    }

    public static Integer removeDevice(Integer osDevice, OsDeviceEnum osDeviceEnum)
    {
        return osDevice & (~(1 << osDeviceEnum.getCode()));
    }

}
