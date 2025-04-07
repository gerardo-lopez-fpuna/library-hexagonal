package com.library.infrastructure.adapter.output.jpa;

import com.library.application.port.output.BookRepository;
import com.library.domain.model.Book;
import com.library.domain.valueobject.ISBN;
import com.library.infrastructure.adapter.output.jpa.entity.BookEntity;
import com.library.infrastructure.adapter.output.jpa.repository.SpringDataBookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BookJpaRepository implements BookRepository {

    private final SpringDataBookRepository repository;

    public BookJpaRepository(SpringDataBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        BookEntity savedEntity = repository.save(toEntity(book));
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Book> findByIsbn(ISBN isbn) {
        return repository.findById(isbn.value())
                .map(this::toDomain);
    }



    @Override
    public List<Book> findAll() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Book book) {
        repository.delete(toEntity(book));
    }

    @Override
    public boolean existsByIsbn(ISBN isbn) {
        return repository.existsById(isbn.value());
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
                book.getIsbn().value(),
                book.getTitle(),
                book.getAuthor(),
                book.getAvailableCopies()
        );
    }
}