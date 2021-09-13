package com.idofast.protocol.command;

import com.idofast.protocol.common.CommandTypeEnum;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/5/24 1:45 上午
 */
public class Command<T, R>
{
    CommandTypeEnum type ;
    T request;
    R response;

}
