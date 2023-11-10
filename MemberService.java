package com.example.Cell.Service;

import com.example.Cell.Domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Long join (Member member);
    Optional<Member> findById (Long id);
    Optional<Member> findByUsername (String username);
    List<Member> findAll ();
    void validDuplicateMember (Member member);
}
