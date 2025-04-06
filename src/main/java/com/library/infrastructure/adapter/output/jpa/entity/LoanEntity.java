// src/main/java/com/library/infrastructure/adapter/output/jpa/entity/LoanEntity.java
package com.library.infrastructure.adapter.output.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "loans")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookIsbn;
    private String memberId;
    private LocalDate loanDate;
    private LocalDate returnDate;
}