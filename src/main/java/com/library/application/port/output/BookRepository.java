package com.library.application.port.output;

import com.library.domain.model.Book;
import com.library.domain.valueobject.ISBN;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {
    Optional<Book> findByIsbn(ISBN isbn);
    Book save(Book book);
    List<Book> findAll();
    void delete(Book book);
    boolean existsByIsbn(ISBN isbn);
}