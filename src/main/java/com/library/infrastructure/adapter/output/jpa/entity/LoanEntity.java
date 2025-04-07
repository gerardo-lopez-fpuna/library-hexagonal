// src/main/java/com/library/infrastructure/adapter/output/jpa/entity/LoanEntity.java
package com.library.infrastructure.adapter.output.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name = "loans")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // Para JPA
@AllArgsConstructor // Para tests
@Builder // Patrón builder opcional
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookIsbn;
    private String memberId;
    private LocalDate loanDate;
    private LocalDate returnDate;

    // Constructor mínimo requerido
    public LoanEntity(String bookIsbn, String memberId, LocalDate loanDate) {
        this.bookIsbn = bookIsbn;
        this.memberId = memberId;
        this.loanDate = loanDate;
        this.returnDate = null;
    }
}