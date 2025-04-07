package com.library.application.service;

import com.library.application.exception.BookNotFoundException;
import com.library.application.exception.MemberNotFoundException;
import com.library.application.port.input.BorrowBookUseCase;
import com.library.application.port.output.BookRepository;
import com.library.application.port.output.LoanRepository;
import com.library.application.port.output.MemberRepository;
import com.library.domain.model.Book;
import com.library.domain.model.LibraryMember;
import com.library.domain.model.Loan;
import com.library.domain.valueobject.ISBN;
import com.library.domain.valueobject.LoanDate;
import com.library.domain.valueobject.MemberId;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BorrowBookService implements BorrowBookUseCase {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;

    public BorrowBookService(BookRepository bookRepository,
                             MemberRepository memberRepository,
                             LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
    }

    @Override
    @Transactional
    public boolean borrowBook(ISBN isbn, MemberId memberId) {
        Book book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException(isbn));

        LibraryMember member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));

        if (book.isAvailable() && member.canBorrow()) {
            book.decreaseAvailability();
            member.incrementBorrowedBooks();

            Loan loan = new Loan(book, member, new LoanDate(LocalDate.now()));

            bookRepository.save(book);
            memberRepository.save(member);
            loanRepository.save(loan);

            return true;
        }
        return false;
    }


}