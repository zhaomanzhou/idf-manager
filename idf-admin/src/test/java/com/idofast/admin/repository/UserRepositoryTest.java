package com.idofast.admin.repository;

import com.idofast.admin.domain.User;
import com.idofast.common.enums.RoleEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest
{
    @Autowired
    private UserRepository userRepository;


    @Test
    public void testJpa()
    {
        User user = User.builder().nickname("ff")
                .email("aa")
                .password("111")
                .remark("dd")
                .status(1)
                .role(RoleEnum.ADMIN)
                .build();
        userRepository.save(user);
    }
}