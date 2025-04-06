package com.library.application.port.input;

import com.library.domain.valueobject.ISBN;

public interface ReturnBookUseCase {
    void returnBook(ISBN isbn);
}