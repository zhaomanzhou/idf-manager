package com.idofast.protocol.common;

import lombok.Data;

import java.nio.channels.Channel;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/9/12 10:06 下午
 */
@Data
public class CommandContext
{
    private Channel channel;
}
