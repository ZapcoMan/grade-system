package com.example.strategy.impl;

import com.example.entity.Account;
import com.example.enums.RoleEnum;
import com.example.service.UserService;
import com.example.strategy.RoleStrategy;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class TeacherStrategy implements RoleStrategy {

    @Resource
    private UserService teacherService;

    @Override
    public String getRole() {
        return RoleEnum.TEACHER.getCode(); // "TEACHER"
    }

    @Override
    public Account login(Account account) {
        return teacherService.login(account);
    }

    @Override
    public void updatePassword(Account account) {
        teacherService.updatePassword(account);
    }
}