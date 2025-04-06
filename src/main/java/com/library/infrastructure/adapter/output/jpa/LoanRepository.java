// src/main/java/com/library/infrastructure/adapter/output/jpa/LoanJpaRepository.java
package com.library.infrastructure.adapter.output.jpa;

import com.library.application.port.output.LoanRepository;
import com.library.domain.model.Loan;
import com.library.domain.valueobject.ISBN;
import com.library.infrastructure.adapter.output.jpa.entity.LoanEntity;
import com.library.infrastructure.adapter.output.jpa.repository.SpringDataLoanRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class LoanJpaRepository implements LoanRepository {

    private final SpringDataLoanRepository repository;

    public LoanJpaRepository(SpringDataLoanRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Loan loan) {
        repository.save(toEntity(loan));
    }

    @Override
    public Optional<Loan> findActiveLoanByIsbn(ISBN isbn) {
        return Optional.empty();
    }

    private LoanEntity toEntity(Loan loan) {
        return new LoanEntity(
                loan.getBook().getIsbn().value(),
                loan.getMember().getMemberId().value(),
                loan.getLoanDate().date(),
                loan.getReturnDate() != null ? loan.getReturnDate().date() : null
        );
    }
}