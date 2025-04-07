package com.library.application.port.output;

import com.library.domain.model.Loan;
import com.library.domain.valueobject.ISBN;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository {
    void save(Loan loan);
    Optional<Loan> findActiveLoanByIsbn(ISBN isbn);
}