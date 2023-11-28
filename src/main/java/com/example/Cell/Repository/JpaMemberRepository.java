package com.example.Cell.Repository;

import com.example.Cell.Domain.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class JpaMemberRepository implements MemberRepository {
    private final EntityManager entityManager;

    @Autowired
    public JpaMemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Member save(Member member) {
        if (member.getId() == null) {
            entityManager.persist(member);
        } else {
            entityManager.merge(member);
        }
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByUsername(String name) {
        String jpql = "SELECT m FROM Member m WHERE m.userName = :userName";
        TypedQuery<Member> query = entityManager.createQuery(jpql, Member.class);
        query.setParameter("userName", name);

        try {
            Member member = query.getSingleResult();
            return Optional.of(member);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Member> findAll() {
        String jpql = "SELECT m FROM Member m";
        TypedQuery<Member> query = entityManager.createQuery(jpql, Member.class);
        return query.getResultList();
    }
}
