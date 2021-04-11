package com.idofast.admin.util;

import java.security.SecureRandom;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/11 4:19 下午
 */
public class randomCharUtil
{
    public static String generateInviteCode(int length) {

        SecureRandom random = new SecureRandom();

        StringBuffer valSb = new StringBuffer();

        String charStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int charLength = charStr.length();


        for (int i = 0; i < length; i++) {

            int index = random.nextInt(charLength);

            valSb.append(charStr.charAt(index));

        }

        return valSb.toString();

    }



}
