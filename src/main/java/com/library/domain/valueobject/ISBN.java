package com.library.domain.valueobject;

import java.util.regex.Pattern;

public record ISBN(String value) {
    private static final Pattern ISBN_PATTERN =
            Pattern.compile("^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)");

    public ISBN {
        if (value == null || !ISBN_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("ISBN inválido");
        }
    }
}