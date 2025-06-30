package com.example.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Account {

    private Integer id;
    private String username;
    private String password;
    private String role;
    private String name;

    private String token;

    private String avatar;
    private String newpassword;
    private String new2password;

}
