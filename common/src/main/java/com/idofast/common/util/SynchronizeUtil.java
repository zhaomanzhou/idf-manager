package com.idofast.common.util;

import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
import org.springframework.stereotype.Component;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/5/24 1:29 上午
 */
@Component
public class SynchronizeUtil
{
    private final Interner<String> STRING_WEAK_POLL = Interners.newWeakInterner();

    public String getWeakReference(String t)
    {
        return STRING_WEAK_POLL.intern(t);
    }


}
