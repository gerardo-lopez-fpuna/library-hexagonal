package com.library.domain.model;

import com.library.domain.valueobject.LoanDate;

public class Loan {
    private final Book book;
    private final LibraryMember member;
    private final LoanDate loanDate;
    private LoanDate returnDate;

    public Loan(Book book, LibraryMember member, LoanDate loanDate) {
        this.book = book;
        this.member = member;
        this.loanDate = loanDate;
    }

    public void markAsReturned(LoanDate returnDate) {
        this.returnDate = returnDate;
        book.increaseAvailability();
        member.decrementBorrowedBooks();
    }

    // Getters
    public Book getBook() { return book; }
    public LibraryMember getMember() { return member; }
    public LoanDate getLoanDate() { return loanDate; }
    public LoanDate getReturnDate() { return returnDate; }
}