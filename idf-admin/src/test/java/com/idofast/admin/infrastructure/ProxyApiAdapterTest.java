package com.idofast.admin.infrastructure;

import com.idofast.common.response.error.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/17 4:47 下午
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProxyApiAdapterTest
{

    @Autowired
    private ProxyApiAdapter proxyApiAdapter;
    @Test
    public void rmAccount() throws BusinessException
    {
        proxyApiAdapter.rmAccount(12233L, "127.0.0.1");
    }
}