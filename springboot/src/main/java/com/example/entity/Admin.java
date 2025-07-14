package com.example.entity;

import lombok.Data;

/**
 * 管理员信息
 */
@Data
public class Admin extends Account {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private String name;

    private String token;

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

    private String avatar;

    @Override
    public String getAvatar() {
        return avatar;
    }

    @Override
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}