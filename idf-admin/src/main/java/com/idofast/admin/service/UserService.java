package com.idofast.admin.service;


import com.idofast.admin.domain.User;
import com.idofast.admin.repository.UserRepository;
import com.idofast.common.enums.UserStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public boolean userExistByEmail(String email)
    {
        User user = new User();
        user.setStatus(UserStatusEnum.NORMAL);
        user.setEmail(email);
        Optional<User> one = userRepository.findOne(Example.of(user));
        return one.isPresent();
    }



}
