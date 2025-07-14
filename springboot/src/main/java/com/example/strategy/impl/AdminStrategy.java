package com.example.strategy.impl;

import com.example.entity.Account;
import com.example.entity.Admin;
import com.example.enums.RoleEnum;
import com.example.service.AdminService;
import com.example.strategy.RoleStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminStrategy implements RoleStrategy {

    @Autowired
    private AdminService adminService;

    @Override
    public String getRole() {
        return RoleEnum.ADMIN.getCode(); // "ADMIN"
    }

    @Override
    public Account login(Account account) {
        return adminService.login(account);
    }

    @Override
    public void updatePassword(Account account) {
        adminService.updatePassword(account);
    }

    @Override
    public void register(Account account) {
        // 新建一个Admin对象 从 account 中取出一个admin 对象来
        Admin admin = new Admin();
        admin.setUsername(account.getUsername());
        admin.setPassword(account.getPassword());
        adminService.add(admin);
    }
}

