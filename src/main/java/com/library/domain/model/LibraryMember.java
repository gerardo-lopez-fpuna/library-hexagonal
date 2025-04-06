package com.library.domain.model;

import com.library.domain.valueobject.MemberId;
import com.library.domain.spec.MemberCanBorrowSpec;

public class LibraryMember {
    private final MemberId memberId;
    private String name;
    private String email;
    private int borrowedBooksCount;

    public LibraryMember(MemberId memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.borrowedBooksCount = 0;
    }

    public boolean canBorrow() {
        return new MemberCanBorrowSpec().isSatisfiedBy(this);
    }

    public void incrementBorrowedBooks() {
        this.borrowedBooksCount++;
    }

    public void decrementBorrowedBooks() {
        if (this.borrowedBooksCount > 0) {
            this.borrowedBooksCount--;
        }
    }

    // Getters
    public MemberId getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getBorrowedBooksCount() { return borrowedBooksCount; }
}