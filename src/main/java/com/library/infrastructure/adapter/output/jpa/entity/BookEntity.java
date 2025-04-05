package com.library.infrastructure.adapter.output.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    private String isbn;  // Usamos ISBN como ID
    private String title;
    private String author;
    private int availableCopies;
}