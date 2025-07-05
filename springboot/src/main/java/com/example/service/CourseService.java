package com.example.service;


import com.example.entity.Course;

import java.util.List;

public interface CourseService {
    Course getById(Long id);
    List<Course> list();
    void create(Course c);
    void update(Course c);
    void delete(Long id);
}

