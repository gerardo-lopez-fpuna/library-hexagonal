// src/main/java/com/library/infrastructure/adapter/output/jpa/repository/SpringDataLoanRepository.java
package com.library.infrastructure.adapter.output.jpa.repository;

import com.library.infrastructure.adapter.output.jpa.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataLoanRepository extends JpaRepository<LoanEntity, Long> {
}