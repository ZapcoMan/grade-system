package com.example.service.account.impl;

import com.example.entity.Account;
import com.example.entity.User;
import com.example.enums.RoleEnum;
import com.example.mapper.UserMapper;
import com.example.service.AccountService;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements AccountService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;
    @Override
    public RoleEnum getRole() {
        return RoleEnum.USER;
    }

    @Override
    public Account selectById(String id) {
        return userService.selectById(id);
    }

    @Override
    public Account login(Account account) {
        return userService.login(account);
    }

    @Override
    public void updatePassword(Account account) {
        userService.updatePassword(account);
    }

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }
}