package com.example.service;


import com.example.entity.Student;

import java.util.List;

public interface StudentService {
    Student getById(Long id);

    List<Student> list();

    void create(Student student);

    void update(Student student);

    void delete(Long id);

    Student getByUserId(Long userId);
}