package com.example.mapper;


import com.example.entity.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ScoreMapper接口用于定义与成绩相关的数据库操作
 * 它是一个标记接口，通过@Mapper注解标识，用于MyBatis框架的映射
 */
@Mapper
public interface ScoreMapper {
    /**
     * 根据成绩记录的ID查询成绩对象
     *
     * @param id 成绩记录的唯一标识符
     * @return 返回查询到的成绩对象，如果找不到则返回null
     */
    Score findById(Long id);

    /**
     * 查询所有成绩记录
     *
     * @return 返回一个包含所有成绩记录的列表
     */
    List<Score> findAll();

    /**
     * 插入一条新的成绩记录
     *
     * @param score 要插入的成绩对象
     * @return 返回插入操作影响的行数
     */
    int insert(Score score);

    /**
     * 更新一条成绩记录
     *
     * @param score 包含更新数据的成绩对象
     * @return 返回更新操作影响的行数
     */
    int update(Score score);

    /**
     * 根据成绩记录的ID删除该记录
     *
     * @param id 成绩记录的唯一标识符
     * @return 返回删除操作影响的行数
     */
    int deleteById(Long id);

    /**
     * 根据学生id查询成绩列表
     *
     * @param studentId 学生的唯一标识符
     * @return 返回一个包含指定学生所有成绩记录的列表
     */
    List<Score> findByStudentId(Long studentId);

    /**
     * 根据课程id查询成绩列表
     *
     * @param courseId 课程的唯一标识符
     * @return 返回一个包含指定课程所有成绩记录的列表
     */
    List<Score> findByCourseId(Long courseId);
}
