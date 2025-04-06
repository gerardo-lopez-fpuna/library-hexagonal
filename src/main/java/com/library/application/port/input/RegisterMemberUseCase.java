package com.library.application.port.input;

import com.library.domain.model.LibraryMember;

public interface RegisterMemberUseCase {
    LibraryMember registerMember(LibraryMember member);
}