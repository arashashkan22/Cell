package com.example.Cell.Config;


import com.example.Cell.Repository.MemoryMemberRepository;
import com.example.Cell.Service.MemberServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {
    @Test
    void configurationTest () {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImp memberService = ac.getBean(MemberServiceImp.class);
        MemoryMemberRepository memberRepository = ac.getBean("memberRepository", MemoryMemberRepository.class);

        System.out.println("memberRepository = " + memberRepository);
        System.out.println("memberService = " + memberService);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);


    }
    @Test
    void findAllBean () {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        String [] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            Object been = ac.getBean(name);
            System.out.println("name = " + name + " object = " + been);
        }
    }
    @Test
    void configurationDeep () {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean.getClass() = " + bean.getClass());
    }
}
