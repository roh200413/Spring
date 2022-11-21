package com.example.specification.service;

import com.example.specification.data.MemberDto;
import com.example.specification.domain.Member;
import com.example.specification.repository.MemberRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    MemberDto create(MemberDto req);
    List<MemberDto> getData(Specification<Member> req);
}
