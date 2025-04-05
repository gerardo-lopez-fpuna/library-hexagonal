package com.library.infrastructure.adapter.output.jpa.repository;

import com.library.infrastructure.adapter.output.jpa.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBookRepository extends JpaRepository<BookEntity, String> {
}