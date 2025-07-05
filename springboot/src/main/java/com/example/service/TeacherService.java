package com.example.service;


import com.example.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher getById(Long id);

    List<Teacher> list();

    void create(Teacher teacher);

    void update(Teacher teacher);

    void delete(Long id);

    Teacher getByUserId(Long userId);
}