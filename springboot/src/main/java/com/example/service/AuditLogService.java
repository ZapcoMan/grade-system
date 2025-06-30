package com.example.service;


import com.example.entity.AuditLog;

import java.util.List;

public interface AuditLogService {
    void saveLog(AuditLog log);

    List<AuditLog> getRecentLogs(int limit);
}
