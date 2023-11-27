package com.example.Cell.Repository;

import com.example.Cell.Domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    void save () {
        Member member = new Member();
        member.setUsername("test1");
        member.setName("test2");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
        Assertions.assertThat(result).isEqualTo(member);
    }
    @Test
    void findAll () {
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("person1");
        member2.setName("person2");
        repository.save(member1);
        repository.save(member2);

        List<Member> result = repository.findAll();

        System.out.println("result = " + result);
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
    @Test
    void findByUsername () {
        Member member1 = new Member();
        member1.setUsername("person1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setUsername("person2");
        repository.save(member2);

        Member result = repository.findByUserName("person2").get();

        Assertions.assertThat(result).isEqualTo(member2);
    }
}
