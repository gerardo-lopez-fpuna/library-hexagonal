package com.library.domain.model;

import com.library.domain.valueobject.ISBN;
import com.library.domain.spec.BookAvailableSpec;

public class Book {
    private final ISBN isbn;
    private String title;
    private String author;
    private int availableCopies;

    public Book(ISBN isbn, String title, String author, int availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    // Comportamiento de dominio
    public boolean isAvailable() {
        return new BookAvailableSpec().isSatisfiedBy(this);
    }

    public void decreaseAvailability() {
        if (!isAvailable()) {
            throw new IllegalStateException("No hay copias disponibles");
        }
        this.availableCopies--;
    }

    public void increaseAvailability() {
        this.availableCopies++;
    }

    // Getters
    public ISBN getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getAvailableCopies() { return availableCopies; }
}