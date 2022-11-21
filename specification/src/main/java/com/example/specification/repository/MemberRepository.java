package com.example.specification.repository;

import com.example.specification.data.MemberDto;
import com.example.specification.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MemberRepository extends JpaRepository<Member,  Long>, JpaSpecificationExecutor<Member> {
}
