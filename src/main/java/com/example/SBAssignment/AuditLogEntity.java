package com.example.SBAssignment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_log")
@Getter @Setter @NoArgsConstructor
public class AuditLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employee_id")
    private Long employeeId;
    private String action;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
