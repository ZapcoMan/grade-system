package com.example.controller;

import com.example.common.R;
import com.example.entity.Account;
import com.example.entity.User;
import com.example.exception.CustomerException;
import com.example.service.Impl.AdminServiceImpl;
import com.example.service.Impl.UserServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Resource
    AdminServiceImpl adminServiceImpl;
    @Resource
    UserServiceImpl userServiceImpl;


    //  表示这是一个 get请求的接口
    @GetMapping("/hello") // 接口的路径，全局唯一的
    public R hello() {
        return R.ok().message("hello");  // 接口的返回值
    }

    @PostMapping("/login")
    public R login(@RequestBody Account account) {
        Account dbAccount = null;
        if ("ADMIN".equals(account.getRole())) {
            dbAccount = adminServiceImpl.login(account);
        }else if ("USER".equals(account.getRole())) {
            dbAccount = userServiceImpl.login(account);
        }else {
            throw new CustomerException("非法请求");
        }
        return R.success(dbAccount);
    }

    @PostMapping("/register")
    public R register(@RequestBody User user) {
        userServiceImpl.register(user);
        return R.ok();
    }

    @PostMapping("/updatePassword")
    public R UpdatePassword(@RequestBody Account account) {
        if("ADMIN".equals(account.getRole())){
            adminServiceImpl.updatePassword(account);
        }
        if("USER".equals(account.getRole())){
            userServiceImpl.updatePassword(account);
        }


        return R.ok();
    }

}