package com.library.application.port.output;

import com.library.domain.model.LibraryMember;
import com.library.domain.valueobject.MemberId;
import java.util.Optional;

public interface MemberRepository {
    LibraryMember save(LibraryMember member);
    Optional<LibraryMember> findById(MemberId memberId);
}