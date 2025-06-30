package com.example.service.Impl;

import cn.hutool.core.util.StrUtil;
import com.example.entity.Account;
import com.example.entity.User;
import com.example.exception.CustomerException;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    public void add(User user) {
        // 根据新的账号查询数据库  是否存在同样账号的数据
        User dbUser = userMapper.selectByUsername(user.getUsername());
        if (dbUser != null) {
            throw new CustomerException("账号重复");
        }
        // 默认密码
        if (StrUtil.isBlank(user.getPassword())) {
            user.setPassword("123456");
        }
        if (StrUtil.isBlank(user.getName())) {
            user.setName(user.getUsername());
        }
        user.setRole("USER");
        userMapper.insert(user);
    }

    public void update(User user) {
        userMapper.updateById(user);
    }

    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    public void deleteBatch(List<User> list) {
        for (User user : list) {
            this.deleteById(user.getId());
        }
    }

    public List<User> selectAll() {
        return userMapper.selectAll(null);
    }

    public PageInfo<User> selectPage(Integer pageNum, Integer pageSize, User user) {
        // 开启分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.selectAll(user);
        return PageInfo.of(list);
    }

    public void register(User user) {
        this.add(user);
    }

    public User login(Account account) {
        // 验证账号是否存在
        User dbUser = userMapper.selectByUsername(account.getUsername());
        if (dbUser == null) {
            throw new CustomerException("账号不存在");
        }
        // 验证密码是否正确
        if (!dbUser.getPassword().equals(account.getPassword())) {
            throw new CustomerException("账号或密码错误");
        }

        // 创建token并返回给前端
        String token = TokenUtils.createToken(dbUser.getId() + "-" + "USER", dbUser.getPassword());
        dbUser.setToken(token);

        return dbUser;
    }

    public User selectById(String id) {
        return userMapper.selectById(id);
    }

    public void updatePassword(Account account) {
        //判断新密码和旧密码是否相等
        if(!account.getNewpassword().equals(account.getNew2password())){
            throw  new CustomerException("500","你两次输入的密码不一致");
        }
        //判断原密码是否正确
        Account currentUser = TokenUtils.getCurrentUser();
        if(!account.getPassword().equals(currentUser.getPassword())){
            throw new CustomerException("500", "原密码输入错误");
        }
        //开始更新密码
        User user = userMapper.selectById(currentUser.getId().toString());
        user.setPassword(account.getNewpassword());
        userMapper.updateById(user);
    }

}