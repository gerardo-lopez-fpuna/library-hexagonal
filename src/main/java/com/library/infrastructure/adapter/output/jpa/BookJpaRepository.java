package com.library.infrastructure.adapter.output.jpa;

import com.library.application.port.output.BookRepository;
import com.library.domain.model.Book;
import com.library.domain.valueobject.ISBN;
import com.library.infrastructure.adapter.output.jpa.entity.BookEntity;
import com.library.infrastructure.adapter.output.jpa.repository.SpringDataBookRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BookJpaRepository implements BookRepository {

    private final SpringDataBookRepository repository;

    public BookJpaRepository(SpringDataBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Book> findByIsbn(ISBN isbn) {
        return repository.findById(isbn.getValue())
                .map(this::toDomain);
    }

    @Override
    public void save(Book book) {
        repository.save(toEntity(book));
    }

    private Book toDomain(BookEntity entity) {
        return new Book(
                new ISBN(entity.getIsbn()),
                entity.getTitle(),
                entity.getAuthor(),
                entity.getAvailableCopies()
        );
    }

    private BookEntity toEntity(Book book) {
        return new BookEntity(
                book.getIsbn().getValue(),
                book.getTitle(),
                book.getAuthor(),
                book.getAvailableCopies()
        );
    }
}