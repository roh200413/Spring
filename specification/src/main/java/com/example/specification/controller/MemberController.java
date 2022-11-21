package com.example.specification.controller;

import com.example.specification.data.MemberDto;
import com.example.specification.domain.Member;
import com.example.specification.repository.MemberSpecification;
import com.example.specification.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/hello")
    @RequestMapping(method = RequestMethod.GET, value="/list/getdata")
    public List<MemberDto> getData(@RequestParam(required = false) String name,
                                             @RequestParam(required = false) String email,
                                             @RequestParam(required = false) String organization) {

        Specification<Member> spec = (root, query, criteriaBuilder) -> null;

        if (name != null)
            spec = spec.and(MemberSpecification.likeName(name));
        if (email != null)
            spec = spec.and(MemberSpecification.equalEmail(email));
        if (organization != null)
            spec = spec.and(MemberSpecification.equalOrganization(organization));

        return memberService.getData(spec);
    }
}
