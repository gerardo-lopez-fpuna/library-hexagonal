package com.library.domain.spec;

import com.library.domain.model.LibraryMember;

public class MemberCanBorrowSpec {
    private static final int MAX_BOOKS_PER_MEMBER = 5;

    public boolean isSatisfiedBy(LibraryMember member) {
        return member.getBorrowedBooksCount() < MAX_BOOKS_PER_MEMBER;
    }
}