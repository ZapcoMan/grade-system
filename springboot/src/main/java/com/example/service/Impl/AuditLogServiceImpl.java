package com.example.service.Impl;



import com.example.entity.AuditLog;
import com.example.mapper.AuditLogMapper;
import com.example.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    @Autowired
    private AuditLogMapper auditLogMapper;

    @Override
    public void saveLog(AuditLog log) {
        auditLogMapper.insert(log);
    }

    @Override
    public List<AuditLog> getRecentLogs(int limit) {
        return auditLogMapper.selectRecent(limit);
    }
}
