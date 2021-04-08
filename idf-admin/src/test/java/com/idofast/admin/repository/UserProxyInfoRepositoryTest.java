package com.idofast.admin.repository;

import com.idofast.admin.domain.UserProxyInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2020/12/31 12:28 上午
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserProxyInfoRepositoryTest
{
    @Autowired
    private UserProxyInfoRepository dataInfoRepository;

    @Test
    public void testSelect()
    {
        Optional<UserProxyInfo> byId = dataInfoRepository.findById(1L);
        System.out.println(byId.get().getExpireDate());
    }


    @Test
    public void testSave()
    {
        UserProxyInfo info = new UserProxyInfo();
        info.setBundleName("aa");
        dataInfoRepository.save(info);
    }

    @Test
    public void testCustomerInsert()
    {
        UserProxyInfo info = new UserProxyInfo();
        info.setId(1212L);
        info.setBundleName("aa");
        info.setBundleId(124L);
        dataInfoRepository.insertWithGivenId(info);
    }

    @Test
    public void testSave2()
    {

        List<UserProxyInfo> proxyInfoList = dataInfoRepository.findAllByNextSettleDateBeforeAndAndExpireDateAfter(LocalDateTime.now(), LocalDateTime.now());
        System.out.println(proxyInfoList);
    }


}