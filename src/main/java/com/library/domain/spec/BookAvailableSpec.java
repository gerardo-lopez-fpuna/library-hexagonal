package com.library.domain.spec;

import com.library.domain.model.Book;

public class BookAvailableSpec {
    public boolean isSatisfiedBy(Book book) {
        return book.getAvailableCopies() > 0;
    }
}