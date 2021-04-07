package com.im.util;

import com.idofast.common.enums.OsDeviceEnum;
import org.junit.Test;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/5 5:22 下午
 */
public class OsDeviceEnumTest
{

    @Test
    public void test01()
    {
        Integer defaultDevice = 0;
        System.out.println(OsDeviceEnum.convertToStringList(defaultDevice));

        defaultDevice = OsDeviceEnum.addDevice(defaultDevice, OsDeviceEnum.ANDROID);
        defaultDevice = OsDeviceEnum.addDevice(defaultDevice, OsDeviceEnum.WIN7);
        defaultDevice = OsDeviceEnum.addDevice(defaultDevice, OsDeviceEnum.MAC);
        System.out.println(OsDeviceEnum.convertToStringList(defaultDevice));

        defaultDevice = OsDeviceEnum.removeDevice(defaultDevice, OsDeviceEnum.ANDROID);
        defaultDevice = OsDeviceEnum.removeDevice(defaultDevice, OsDeviceEnum.ANDROID);
        System.out.println(OsDeviceEnum.convertToStringList(defaultDevice));

    }
}
