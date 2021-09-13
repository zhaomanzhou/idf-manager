package com.idofast.protocol.command;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/9/12 9:54 下午
 */
public interface CommandExecutor<T>
{
    void execute(Command command);

    T returnExecute(Command command);
}
