package com.library.infrastructure.adapter.output.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    @Id
    private String id;  // Usamos MemberId como ID
    private String name;
    private String email;
}