package com.example.Cell.Controller;

import com.example.Cell.Domain.Member;
import com.example.Cell.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class MemberController {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostMapping("/register")
    public void register(@RequestBody Member member) {
        memberRepository.save(member);
    }

//    @PostMapping("/login")
//    public String login(@RequestBody Member member) {
////        Member existingMember = memberRepository.findByUserName(member.getUsername());
//
//        if (existingMember != null && existingMember.getPassword().equals(member.getPassword())) {
//            return "Login successful";
//        } else {
//            return "Login failed";
//        }
//    }
}
