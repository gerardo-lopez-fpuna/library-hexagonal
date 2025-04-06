package com.library.application.exception;

import com.library.domain.valueobject.ISBN;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(ISBN isbn) {
        super("Libro no encontrado con ISBN: " + isbn.value());
    }
}