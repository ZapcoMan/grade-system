package com.example.controller;


import com.example.annotation.AuditLogRecord;
import com.example.common.R;
import com.example.entity.Student;
import com.example.service.StudentService;
import jakarta.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

/**
 * 学生控制器类，处理与学生相关的HTTP请求
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    // 静态日志记录器
    private static final Log log = LogFactory.getLog(StudentController.class);

    // 学生服务接口的实例
    @Resource
    private StudentService studentService;

    /**
     * 获取学生列表
     *
     * @return 包含学生列表的响应对象
     */
    @AuditLogRecord(action = "Get StudentList", resource = "Student")
    @GetMapping
    public R list() {
        return R.success(studentService.list());
    }

    /**
     * 根据ID获取学生信息
     *
     * @param id 学生的ID
     * @return 包含学生信息的响应对象
     */
    @AuditLogRecord(action = "Get Student", resource = "Student")
    @GetMapping("/{id}")
    public R get(@PathVariable Long id) {
        log.info("Get Student id = " + id);
        return R.success(studentService.getById(id));
    }

    /**
     * 创建新学生
     *
     * @param student 新学生的信息
     */
    @AuditLogRecord(action = "Create Student", resource = "Student")
    @PostMapping
    public void create(@RequestBody Student student) {
        log.info("Create Student = " + student);
        studentService.create(student);
    }

    /**
     * 更新学生信息
     *
     * @param student 更新后学生的信息
     */
    @AuditLogRecord(action = "Update Student", resource = "Student")
    @PutMapping
    public void update(@RequestBody Student student) {
        log.info("Update Student = " + student);
        studentService.update(student);
    }

    /**
     * 删除学生
     *
     * @param id 要删除的学生的ID
     */
    @AuditLogRecord(action = "Delete Student", resource = "Student")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Delete Student By ID = " + id);
        studentService.delete(id);
    }

    /**
     * 根据用户ID获取学生信息
     *
     * @param userId 用户的ID
     * @return 对应用户的学生信息
     */
    @AuditLogRecord(action = "Get Student by UserId", resource = "Student")
    @GetMapping("/user/{userId}")
    public Student getByUserId(@PathVariable Long userId) {
        return studentService.getByUserId(userId);
    }
}
