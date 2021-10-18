package com.idofast.proxy.biz.adapter;

import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.response.exception.BusinessException;
import com.idofast.proxy.service.V2rayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/12 3:57 下午
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProxyAccountAdaptTest
{

    @Autowired
    private ProxyAccountAdapt accountAdapt;

    @Autowired
    private V2rayService v2rayService;

    @Test
    public void getRemoteV2rayAccountDto()
    {
        V2rayAccountDto dto = new V2rayAccountDto();
        dto.setEmail("27128@qq.com");
        dto.setUuid("e744367c-1e30-49bb-96e1-ed80b7188752");
        v2rayService.addProxyAccount("127.0.0.1", 62789, "6001",dto);


//        System.out.println(accountAdapt.getRemoteV2rayAccountDto(12233L));
    }

    @Test
    public void testGetRemote() throws BusinessException
    {
        System.out.println(accountAdapt.getRemoteV2rayAccountDto(12233L));
        accountAdapt.reportUserState(new ArrayList<>());
    }
}