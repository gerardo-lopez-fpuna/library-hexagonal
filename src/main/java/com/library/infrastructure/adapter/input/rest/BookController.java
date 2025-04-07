package com.library.infrastructure.adapter.input.rest;

import com.library.application.port.input.BookUseCase;
import com.library.application.port.input.BorrowBookUseCase;
import com.library.application.port.input.ReturnBookUseCase;
import com.library.domain.model.Book;
import com.library.domain.valueobject.ISBN;
import com.library.domain.valueobject.MemberId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BorrowBookUseCase borrowBookUseCase;
    private final ReturnBookUseCase returnBookUseCase;
    private final BookUseCase bookUseCase;

    public BookController(BorrowBookUseCase borrowBookUseCase, ReturnBookUseCase returnBookUseCase, BookUseCase bookUseCase) {
        this.borrowBookUseCase = borrowBookUseCase;
        this.bookUseCase = bookUseCase;
        this.returnBookUseCase = returnBookUseCase;
    }

    @PostMapping("/{isbn}/borrow")
    public ResponseEntity<String> borrowBook(
            @PathVariable String isbn,
            @RequestParam String memberId) {
        boolean success = borrowBookUseCase.borrowBook(new ISBN(isbn), new MemberId(memberId));
        return success
                ? ResponseEntity.ok("Book borrowed successfully")
                : ResponseEntity.badRequest().body("Cannot borrow book");
    }

    @PostMapping("/{isbn}/return")
    public ResponseEntity<String> returnBook(@PathVariable String isbn) {
        returnBookUseCase.returnBook(new ISBN(isbn));
        return ResponseEntity.ok("Book returned successfully");
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookUseCase.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn) {
        return bookUseCase.getBookByIsbn(new ISBN(isbn))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookUseCase.getAllBooks());
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Book> updateBook(
            @PathVariable String isbn,
            @RequestBody Book book) {
        if (!new ISBN(isbn).equals(book.getIsbn())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bookUseCase.updateBook(book));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
        bookUseCase.deleteBook(new ISBN(isbn));
        return ResponseEntity.noContent().build();
    }
}