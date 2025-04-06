package com.library.application.service;

import com.library.application.exception.LoanNotFoundException;
import com.library.application.port.input.ReturnBookUseCase;
import com.library.application.port.output.BookRepository;
import com.library.application.port.output.LoanRepository;
import com.library.application.port.output.MemberRepository;
import com.library.domain.model.Loan;
import com.library.domain.valueobject.ISBN;
import com.library.domain.valueobject.LoanDate;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReturnBookService implements ReturnBookUseCase {

    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;

    public ReturnBookService(BookRepository bookRepository,
                             LoanRepository loanRepository,
                             MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional
    public void returnBook(ISBN isbn) {
        Loan loan = loanRepository.findActiveLoanByIsbn(isbn)
                .orElseThrow(() -> new LoanNotFoundException(isbn));

        loan.markAsReturned(new LoanDate(LocalDate.now()));

        bookRepository.save(loan.getBook());
        memberRepository.save(loan.getMember());
        loanRepository.save(loan);
    }
}