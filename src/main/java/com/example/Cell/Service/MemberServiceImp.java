package com.example.Cell.Service;

import com.example.Cell.Domain.Member;
import com.example.Cell.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

//@Service
public class MemberServiceImp implements MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImp (MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    @Override
    public Long join(Member member) {
        validDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUserName(username);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public void validDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByUserName(member.getUsername());
        result.ifPresent(m -> {
            throw new IllegalStateException("You are already a member.");
        });
    }
}
