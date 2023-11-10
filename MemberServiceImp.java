package com.example.Cell.Service;

import com.example.Cell.Domain.Member;
import com.example.Cell.Repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImp implements MemberService {
    private final MemoryMemberRepository memberRepository;

    @Autowired
    public MemberServiceImp (MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
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
        return memberRepository.findBYUserName(username);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public void validDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findBYUserName(member.getUserName());
        result.ifPresent(m -> {
            throw new IllegalStateException("You are already a member.");
        });
    }
}
