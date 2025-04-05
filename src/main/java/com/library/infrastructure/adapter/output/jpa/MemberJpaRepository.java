package com.library.infrastructure.adapter.output.jpa;

import com.library.application.port.output.MemberRepository;
import com.library.domain.model.Member;
import com.library.domain.valueobject.MemberId;
import com.library.infrastructure.adapter.output.jpa.entity.MemberEntity;
import com.library.infrastructure.adapter.output.jpa.repository.SpringDataMemberRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MemberJpaRepository implements MemberRepository {

    private final SpringDataMemberRepository repository;

    public MemberJpaRepository(SpringDataMemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public Member save(Member member) {
        MemberEntity entity = repository.save(toEntity(member));
        return toDomain(entity);
    }

    private MemberEntity toEntity(Member member) {
        return new MemberEntity(
                member.getMemberId().getValue(),
                member.getName(),
                member.getEmail()
        );
    }

    private Member toDomain(MemberEntity entity) {
        return new Member(
                new MemberId(entity.getId()),
                entity.getName(),
                entity.getEmail()
        );
    }
}