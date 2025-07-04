package com.example.service.impl;

import java.util.List;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.AuditLog;
import com.example.mapper.AuditLogMapper;
import com.example.service.AuditLogService;

/**
 * 审计日志服务实现类
 * 该类负责处理审计日志的相关业务逻辑，如保存日志和获取最近的日志记录
 */
@Service
public class AuditLogServiceImpl implements AuditLogService {

    /**
     * 审计日志数据访问对象
     * 用于执行与审计日志相关的数据库操作
     */
    @Resource
    private AuditLogMapper auditLogMapper;

    /**
     * 保存审计日志
     *
     * @param log 审计日志对象，包含日志的所有必要信息
     * 将日志对象插入到数据库中，以便跟踪和审计系统操作
     */
    @Override
    public void saveLog(AuditLog log) {
        auditLogMapper.insert(log);
    }

    /**
     * 获取最近的审计日志
     *
     * @param limit 限制获取的日志记录数量
     * @return 最近的审计日志列表，按时间降序排列
     * 该方法用于获取系统最近的操作日志，帮助管理员监控和审计系统活动
     */
    @Override
    public List<AuditLog> getRecentLogs(int limit) {
        return auditLogMapper.selectRecent(limit);
    }
}
