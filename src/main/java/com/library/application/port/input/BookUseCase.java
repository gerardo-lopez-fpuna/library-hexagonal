package com.library.application.port.input;

import com.library.domain.model.Book;
import com.library.domain.valueobject.ISBN;

import java.util.List;
import java.util.Optional;

public interface BookUseCase {
    Book createBook(Book book);
    Optional<Book> getBookByIsbn(ISBN isbn);
    List<Book> getAllBooks();
    Book updateBook(Book book);
    void deleteBook(ISBN isbn);
}
