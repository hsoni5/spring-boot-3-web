package com.soni.spring.boot3.audit.repository;


import com.soni.spring.boot3.audit.entity.User;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuditRepository extends RevisionRepository<User, String, Integer> {
    // You can define custom methods here if needed
}