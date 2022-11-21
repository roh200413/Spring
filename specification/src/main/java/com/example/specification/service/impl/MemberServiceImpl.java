package com.example.specification.service.impl;

import com.example.specification.data.MemberDto;
import com.example.specification.domain.Member;
import com.example.specification.repository.MemberRepository;
import com.example.specification.service.MemberService;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public MemberDto create(MemberDto req) {
        return null;
    }

    @Override
    public List<MemberDto> getData(Specification<Member> spec) {
        List<Member> customerList = memberRepository.findAll(spec);
        Type listType = new TypeToken<ArrayList<MemberDto>>(){}.getType();
        return mapper.map(customerList, listType);
    }
}
