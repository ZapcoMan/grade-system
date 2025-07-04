package com.example.controller;


import com.example.annotation.AuditLogRecord;
import com.example.common.R;

import com.example.entity.Notification;
import com.example.service.NotificationService;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    private static final Log log = LogFactory.getLog(NotificationController.class);

    @Resource
    private NotificationService notificationService;

    @ApiOperation("发送通知")
    @AuditLogRecord(action = "发送通知", resource = "通知")
    @PostMapping("/send")
    public R  sendNotification(@RequestBody Notification notification) {
        log.info("发送通知");
        notificationService.sendNotification(notification);
        return R.success("sent");
    }

    @ApiOperation("获取用户通知")
    @AuditLogRecord(action = "获取用户通知", resource = "通知")
    @GetMapping("/user/{userId}")
    public R getUserNotifications(@PathVariable Long userId) {
        log.info("获取用户通知");
        return R.success(notificationService.getUserNotifications(userId));
    }

    @ApiOperation("标记通知为已读")
    @AuditLogRecord(action = "标记通知为已读", resource = "通知")
    @PostMapping("/{id}/read")
    public R markAsRead(@PathVariable Long id) {
        notificationService.markAsRead(id);
        return R.success("marked as read");
    }

    @ApiOperation("删除通知")
    @AuditLogRecord(action = "删除通知", resource = "通知")
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return R.success("deleted");
    }
}
