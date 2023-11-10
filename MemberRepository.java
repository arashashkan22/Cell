package com.example.Cell.Repository;

import com.example.Cell.Domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save (Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findBYUserName(String name);

    List<Member> findAll();
}
