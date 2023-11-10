package com.example.Cell.Repository;

import com.example.Cell.Domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long order = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++order);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findBYUserName(String name) {
        return store.values().stream().filter(member -> member.getUserName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore () {
        store.clear();
    }
}
