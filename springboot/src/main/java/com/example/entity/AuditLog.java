package com.example.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditLog {
    private Long id;
    private String username;
    private String action;
    private String resource;
    private String ipAddress;
    private String details;
    private Timestamp createdAt;
}