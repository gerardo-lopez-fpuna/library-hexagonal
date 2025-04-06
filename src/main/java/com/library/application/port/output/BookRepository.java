package com.library.application.port.output;

import com.library.domain.model.Book;
import com.library.domain.valueobject.ISBN;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findByIsbn(ISBN isbn);
    void save(Book book);
}