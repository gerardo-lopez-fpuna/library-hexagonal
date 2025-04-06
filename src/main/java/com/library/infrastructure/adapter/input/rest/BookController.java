package com.library.infrastructure.adapter.input.rest;

import com.library.application.port.input.BorrowBookUseCase;
import com.library.application.port.input.ReturnBookUseCase;
import com.library.domain.valueobject.ISBN;
import com.library.domain.valueobject.MemberId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BorrowBookUseCase borrowBookUseCase;
    private final ReturnBookUseCase returnBookUseCase;

    public BookController(BorrowBookUseCase borrowBookUseCase, ReturnBookUseCase returnBookUseCase) {
        this.borrowBookUseCase = borrowBookUseCase;
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
}