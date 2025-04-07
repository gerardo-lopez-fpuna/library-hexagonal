package com.library.application.service;
import com.library.application.exception.BookNotFoundException;
import com.library.application.port.input.BookUseCase;
import com.library.application.port.output.BookRepository;
import com.library.domain.model.Book;
import com.library.domain.valueobject.ISBN;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookUseCase {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookByIsbn(ISBN isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book) {
        // Verificar que el libro existe
        bookRepository.findByIsbn(book.getIsbn())
                .orElseThrow(() -> new BookNotFoundException(book.getIsbn()));

        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(ISBN isbn) {
        Book book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException(isbn));
        bookRepository.delete(book);
    }
}