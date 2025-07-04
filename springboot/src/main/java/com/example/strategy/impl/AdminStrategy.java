package com.example.strategy.impl;

import com.example.entity.Account;
import com.example.enums.RoleEnum;
import com.example.service.impl.AdminServiceImpl;
import com.example.strategy.RoleStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminStrategy implements RoleStrategy {

    @Autowired
    private AdminServiceImpl adminService;

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
}

