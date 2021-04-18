package com.idofast.admin.util;

import com.google.common.collect.Interner;
import com.google.common.collect.Interners;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/18 12:26 下午
 */
public class LockPoolUtil
{
    private final static Interner< Object> STRING_WEAK_POLL = Interners.newWeakInterner();



    public  static <T> T  getWeakReference(T t){
        return (T) STRING_WEAK_POLL.intern(t);
    }
}
