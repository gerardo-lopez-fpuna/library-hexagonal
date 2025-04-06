package com.library.infrastructure.adapter.output.jpa;

import com.library.application.port.output.MemberRepository;
import com.library.domain.model.LibraryMember;
import com.library.domain.valueobject.MemberId;
import com.library.infrastructure.adapter.output.jpa.entity.MemberEntity;
import com.library.infrastructure.adapter.output.jpa.repository.SpringDataMemberRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MemberJpaRepository implements MemberRepository {

    private final SpringDataMemberRepository repository;

    public MemberJpaRepository(SpringDataMemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public LibraryMember save(LibraryMember member) {
        MemberEntity entity = repository.save(toEntity(member));
        return toDomain(entity);
    }

    @Override
    public Optional<LibraryMember> findById(MemberId memberId) {
        return Optional.empty();
    }

    private MemberEntity toEntity(LibraryMember member) {
        return new MemberEntity(
                member.getMemberId().value(),
                member.getName(),
                member.getEmail()
        );
    }

    private LibraryMember toDomain(MemberEntity entity) {
        return new LibraryMember(
                new MemberId(entity.getId()),
                entity.getName(),
                entity.getEmail()
        );
    }
}