package com.idofast.admin.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest
{

    @Test
    public void generateVCode()
    {
        for (int i = 0; i < 100000; i++)
        {
            System.out.println(Utils.generateVCode());


        }
    }
}