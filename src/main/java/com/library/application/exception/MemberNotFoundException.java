package com.library.application.exception;

import com.library.domain.valueobject.MemberId;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(MemberId memberId) {
        super("Miembro no encontrado con ID: " + memberId.value());
    }
}