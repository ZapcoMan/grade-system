package com.example.controller;



import com.example.annotation.AuditLogRecord;
import com.example.common.R;
import com.example.entity.Score;
import com.example.service.ScoreService;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 成绩控制器类，处理与成绩相关的HTTP请求
 */
@RestController
@RequestMapping("/score")
public class ScoreController {

    /**
     * 日志对象，用于记录日志信息
     */
    private static final Log log = LogFactory.getLog(ScoreController.class);

    /**
     * 成绩服务对象，用于执行成绩相关的业务逻辑
     */
    @Resource
    private ScoreService scoreService;

    /**
     * 获取成绩列表
     *
     * @return 成绩列表
     */
    @ApiOperation("获取成绩列表")
    @AuditLogRecord(action = "Get ScoreList", resource = "Score")
    @GetMapping
    public List<Score> list() {
        log.info("Get ScoreList");
        return scoreService.list();
    }

    /**
     * 根据ID获取成绩信息
     *
     * @param id 成绩的ID
     * @return 成绩信息的响应对象
     */
    @ApiOperation("根据ID获取成绩信息")
    @AuditLogRecord(action = "Get Score", resource = "Score")
    @GetMapping("/{id}")
    public R get(@PathVariable Long id) {
        log.info("Get Score By id = " + id);
        return R.success(scoreService.getById(id));
    }

    /**
     * 创建成绩
     *
     * @param score 要创建的成绩对象
     */
    @ApiOperation("创建成绩")
    @AuditLogRecord(action = "Create Score", resource = "Score")
    @PostMapping
    public void create(@RequestBody Score score) {
        log.info("Create Score = " + score);
        scoreService.create(score);
    }

    /**
     * 更新成绩信息
     *
     * @param score 要更新的成绩对象
     */
    @ApiOperation("更新成绩信息")
    @AuditLogRecord(action = "Update Score", resource = "Score")
    @PutMapping
    public void update(@RequestBody Score score) {
        log.info("Update Score = " + score);
        scoreService.update(score);
    }

    /**
     * 根据ID删除成绩
     *
     * @param id 要删除的成绩的ID
     */
    @ApiOperation("根据ID删除成绩")
    @AuditLogRecord(action = "Delete Score", resource = "Score")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Delete Score By ID = " + id);
        scoreService.delete(id);
    }

    /**
     * 根据学生ID获取成绩信息
     *
     * @param studentId 学生的ID
     * @return 成绩列表
     */
    @ApiOperation("根据学生ID获取成绩信息")
    @AuditLogRecord(action = "Get Score by StudentId", resource = "Score")
    @GetMapping("/student/{studentId}")
    public List<Score> listByStudentId(@PathVariable Long studentId) {
        log.info("Get Score by StudentId = " + studentId);
        return scoreService.listByStudentId(studentId);
    }

    /**
     * 根据课程ID获取成绩信息
     *
     * @param courseId 课程的ID
     * @return 成绩列表
     */
    @ApiOperation("根据课程ID获取成绩信息")
    @AuditLogRecord(action = "Get Score by CourseId", resource = "Score")
    @GetMapping("/course/{courseId}")
    public List<Score> listByCourseId(@PathVariable Long courseId) {
        log.info("Get Score by CourseId = " + courseId);
        return scoreService.listByCourseId(courseId);
    }
}
