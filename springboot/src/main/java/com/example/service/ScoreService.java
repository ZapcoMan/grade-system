package com.example.service;


import com.example.entity.Score;

import java.util.List;

public interface ScoreService {
    Score getById(Long id);

    List<Score> list();

    void create(Score score);

    void update(Score score);

    void delete(Long id);

    List<Score> listByStudentId(Long studentId);

    List<Score> listByCourseId(Long courseId);
}