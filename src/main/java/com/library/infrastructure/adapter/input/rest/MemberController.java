package com.library.infrastructure.adapter.input.rest;

import com.library.application.port.input.RegisterMemberUseCase;
import com.library.domain.model.LibraryMember;
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
    public ResponseEntity<LibraryMember> registerMember(@RequestBody LibraryMember member) {
        LibraryMember registeredMember = registerMemberUseCase.registerMember(member);
        return ResponseEntity.ok(registeredMember);
    }
}