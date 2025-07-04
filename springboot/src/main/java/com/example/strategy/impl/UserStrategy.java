package com.example.strategy.impl;

import com.example.entity.Account;
import com.example.enums.RoleEnum;
import com.example.service.impl.UserServiceImpl;
import com.example.strategy.RoleStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserStrategy implements RoleStrategy {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public String getRole() {
        return RoleEnum.USER.getCode(); // "USER"
    }

    @Override
    public Account login(Account account) {
        return userService.login(account);
    }

    @Override
    public void updatePassword(Account account) {
        userService.updatePassword(account);
    }
}

