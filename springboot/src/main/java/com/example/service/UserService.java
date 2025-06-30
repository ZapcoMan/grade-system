package com.example.service;

import com.example.entity.Account;
import com.example.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(User user);
    void deleteById(Integer id);
    List<User> selectAll();
    PageInfo<User> selectPage(Integer pageNum, Integer pageSize, User user);
    void register(User user);
    User login(Account account);
    User selectById(String id);
    void updatePassword(Account account);
}
