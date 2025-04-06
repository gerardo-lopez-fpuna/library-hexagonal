package com.library.application.port.input;

import com.library.domain.valueobject.ISBN;
import com.library.domain.valueobject.MemberId;

public interface BorrowBookUseCase {
    boolean borrowBook(ISBN isbn, MemberId memberId);
}