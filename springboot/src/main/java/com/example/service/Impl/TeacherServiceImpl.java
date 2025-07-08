package com.example.service.impl;


import com.example.entity.Account;
import com.example.entity.Teacher;
import com.example.exception.CustomerException;
import com.example.mapper.TeacherMapper;
import com.example.mapper.UserMapper;
import com.example.service.TeacherService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public Teacher getById(Long id) {
        return teacherMapper.findById(id);
    }

    @Override
    public List<Teacher> list() {
        return teacherMapper.findAll();
    }

    @Override
    public void create(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherMapper.update(teacher);
    }

    @Override
    public void delete(Long id) {
        teacherMapper.deleteById(id);
    }

    @Override
    public Teacher getByUserId(Long userId) {
        return null;
    }


}