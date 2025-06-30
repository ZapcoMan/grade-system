package com.example.aspect;

import org.springframework.security.core.context.SecurityContextHolder;
import com.example.annotation.AuditLogRecord;
import com.example.entity.AuditLog;
import com.example.service.AuditLogService;
import jakarta.annotation.Resource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Aspect
@Component
public class AuditLogAspect {

    @Resource
    private AuditLogService auditLogService;

    @Around("@annotation(auditLogRecord)")
    public Object handleAudit(ProceedingJoinPoint joinPoint, AuditLogRecord auditLogRecord) throws Throwable {
        Object result = null;
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String ip = RequestContextHolder.currentRequestAttributes() instanceof ServletRequestAttributes
                ? ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr()
                : "unknown";

        try {
            result = joinPoint.proceed();
            return result;
        } finally {
            AuditLog log = AuditLog.builder()
                    .username(username)
                    .action(auditLogRecord.action())
                    .resource(auditLogRecord.resource())
                    .ipAddress(ip)
                    .details(Arrays.toString(joinPoint.getArgs()))
                    .build();
            auditLogService.saveLog(log);
        }
    }
}
