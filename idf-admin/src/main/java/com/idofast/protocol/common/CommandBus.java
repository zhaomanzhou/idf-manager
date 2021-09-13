package com.idofast.protocol.common;

import com.idofast.protocol.command.Command;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/9/12 9:58 下午
 */
public interface CommandBus
{
    void sendCommand(Command command, CommandContext context);
}
