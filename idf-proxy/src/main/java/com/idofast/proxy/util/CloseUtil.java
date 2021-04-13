package com.idofast.proxy.util;

import io.netty.channel.Channel;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/13 11:24 上午
 */
public class CloseUtil
{
    public static void closeChannel(Channel... channels)
    {
        for (Channel channel: channels) {
            if (channel != null && channel.isOpen()  && channel.isActive()) {
                channel.close().addListener(f -> {
                    if(!f.isSuccess()){
                        System.out.println("Channel2 关闭失败, 失败原因。。。");
                        f.cause().printStackTrace();
                    }
                });
            }
        }
    }
}
