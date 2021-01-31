package com.idofast.admin.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/1/26 7:15 下午
 */
public class LocalDateTimeUtil
{
    public static long toTimeStamp(LocalDateTime localDateTime)
    {
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }
}
