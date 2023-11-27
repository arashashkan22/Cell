package com.example.Cell.Service;

import com.example.Cell.Domain.Member;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface  MemberService {
    Long join (Member member);
    Optional<Member> findById (Long id);
    Optional<Member> findByUsername (String username);
    List<Member> findAll ();
    void validDuplicateMember (Member member);
}
