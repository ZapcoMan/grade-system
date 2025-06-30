package com.example.service;

import com.example.entity.Account;
import com.example.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {
    public void add(Admin admin);
    void update(Admin admin);
    void deleteById(Integer id);
    void deleteBatch(List<Admin> list);
    Admin selectById(String id);
    List<Admin> selectAll();
    PageInfo<Admin> selectPage(Integer pageNum, Integer pageSize, Admin admin);
    Admin login(Account account);
    void updatePassword(Account account);
}
