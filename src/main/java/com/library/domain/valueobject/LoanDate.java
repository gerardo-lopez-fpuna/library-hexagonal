package com.library.domain.valueobject;

import java.time.LocalDate;

public record LoanDate(LocalDate date) {
    public LoanDate {
        if (date == null) {
            date = LocalDate.now();
        }
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha no puede ser futura");
        }
    }
}