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
        return LoanEntity.builder()
                .bookIsbn(loan.getBook().getIsbn().value())
                .memberId(loan.getMember().getMemberId().value())
                .loanDate(loan.getLoanDate().date())
                .returnDate(loan.getReturnDate() != null ? loan.getReturnDate().date() : null)
                .build();
    }

}