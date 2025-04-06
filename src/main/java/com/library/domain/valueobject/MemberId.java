package com.library.domain.valueobject;

import java.util.UUID;

public record MemberId(String value) {
    public MemberId {
        if (value == null || value.isBlank()) {
            value = "member-" + UUID.randomUUID();
        }
    }
}