package com.soni.spring.boot3.audit.repository;

import com.soni.spring.boot3.audit.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
}

