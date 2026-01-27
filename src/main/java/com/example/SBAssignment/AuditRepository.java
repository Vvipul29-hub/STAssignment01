package com.example.SBAssignment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<AuditLogEntity, Long> {
}
