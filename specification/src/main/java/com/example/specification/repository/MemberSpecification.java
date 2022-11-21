package com.example.specification.repository;

import com.example.specification.data.MemberDto;
import com.example.specification.domain.Member;
import org.springframework.data.jpa.domain.Specification;

public class MemberSpecification {
    public static Specification<Member> equalName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }
    public static Specification<Member> likeName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%");
    }
    public static Specification<Member> equalEmail(String email) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), email);
    }
    public static Specification<Member> likeEmail(String email) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("email").as(String.class), "%" + email + "%");
    }
    public static Specification<Member> equalOrganization(String organization) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("organization"), organization);
    }
}
