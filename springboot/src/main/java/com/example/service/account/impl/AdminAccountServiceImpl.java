package com.example.service.account.impl;

import com.example.entity.Account;
import com.example.entity.User;
import com.example.enums.RoleEnum;
import com.example.mapper.AdminMapper;
import com.example.service.AccountService;
import com.example.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AdminAccountServiceImpl implements AccountService {


    @Resource
    private AdminMapper adminMapper;

    @Resource
    private AdminService adminService;
    @Override
    public RoleEnum getRole() {
        return RoleEnum.ADMIN;
    }

    @Override
    public Account selectById(String id) {
        return adminService.selectById(id);
    }

    @Override
    public Account login(Account account) {
        return adminService.login(account);
    }

    @Override
    public void register(User user) {
        AccountService.super.register(user);
    }

    @Override
    public void updatePassword(Account account) {
        adminService.updatePassword(account);
    }
}