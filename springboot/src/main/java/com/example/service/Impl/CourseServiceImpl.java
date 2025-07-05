package com.example.service.impl;


import com.example.entity.Course;
import com.example.mapper.CourseMapper;
import com.example.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper mapper;
    @Override
    public Course getById(Long id) { return mapper.findById(id); }
    @Override
    public List<Course> list() { return mapper.findAll(); }
    @Override
    public void create(Course c) { mapper.insert(c); }
    @Override
    public void update(Course c) { mapper.update(c); }
    @Override
    public void delete(Long id) { mapper.deleteById(id); }
}
