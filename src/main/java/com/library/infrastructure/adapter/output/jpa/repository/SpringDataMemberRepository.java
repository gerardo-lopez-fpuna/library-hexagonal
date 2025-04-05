package com.library.infrastructure.adapter.output.jpa.repository;

import com.library.infrastructure.adapter.output.jpa.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMemberRepository extends JpaRepository<MemberEntity, String> {
}