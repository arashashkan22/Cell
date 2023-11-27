package com.example.Cell.MemberService;

import com.example.Cell.Domain.Member;
import com.example.Cell.Repository.MemoryMemberRepository;
import com.example.Cell.Service.MemberService;
import com.example.Cell.Service.MemberServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach () {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberServiceImp(memberRepository);
    }

    @AfterEach
    public void afterEach () {
        memberRepository.clearStore();
    }
    @Test
    void join () {
        Member member = new Member();
        member.setUsername("member1");

        Long saveId = memberService.join(member);

        Member findMember = memberRepository.findById(saveId).get();
        Assertions.assertThat(member.getUsername()).isEqualTo(findMember.getUsername());
    }
    @Test
    void join2 () {
        Member member = new Member();
        member.setUsername("username1");
        member.setName("name");

        Long id = memberService.join(member);
        Member findMember = memberRepository.findById(id).get();
        System.out.println(findMember.getId());
        System.out.println(member.getId());
        System.out.println(member.getName());
        System.out.println(member.getUsername());
        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());

    }

    @Test
    public void doubleMember () throws Exception {
        Member member1 = new Member();
        member1.setUsername("test1");
        Member member2 = new Member();
        member2.setUsername("test1");

        memberService.join(member1);
        IllegalStateException ex = org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(ex.getMessage()).isEqualTo("You are already a member.");
    }

    @Test
    public void doubleMemberName () throws Exception {
        Member member1 = new Member();
        member1.setName("test1");
        Member member2 = new Member();
        member2.setName("test1");

//        memberService.join(member1);
//        IllegalStateException ex = org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(member1).isNotSameAs(member2);
    }
}
