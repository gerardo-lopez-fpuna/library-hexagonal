package com.library.infrastructure.adapter.input.rest;

import com.library.application.port.input.RegisterMemberUseCase;
import com.library.domain.model.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final RegisterMemberUseCase registerMemberUseCase;

    public MemberController(RegisterMemberUseCase registerMemberUseCase) {
        this.registerMemberUseCase = registerMemberUseCase;
    }

    @PostMapping
    public ResponseEntity<Member> registerMember(@RequestBody Member member) {
        Member registeredMember = registerMemberUseCase.registerMember(member);
        return ResponseEntity.ok(registeredMember);
    }
}