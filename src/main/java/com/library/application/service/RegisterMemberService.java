package com.library.application.service;

import com.library.application.port.input.RegisterMemberUseCase;
import com.library.application.port.output.MemberRepository;
import com.library.domain.model.LibraryMember;
import com.library.domain.valueobject.MemberId;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class RegisterMemberService implements RegisterMemberUseCase {

    private final MemberRepository memberRepository;

    public RegisterMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public LibraryMember registerMember(LibraryMember member) {
        // Asignar ID si no viene definido
        if (member.getMemberId() == null) {
            member = new LibraryMember(new MemberId(UUID.randomUUID().toString()), member.getName(), member.getEmail());
        }

        return memberRepository.save(member);
    }
}