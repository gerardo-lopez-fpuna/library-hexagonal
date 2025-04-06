package com.library.application.exception;

import com.library.domain.valueobject.ISBN;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(ISBN isbn) {
        super("Préstamo activo no encontrado para ISBN: " + isbn.value());
    }
}