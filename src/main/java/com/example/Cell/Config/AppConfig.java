package com.example.Cell.Config;

import com.example.Cell.Repository.MemberRepository;
import com.example.Cell.Repository.MemoryMemberRepository;
import com.example.Cell.Service.MemberService;
import com.example.Cell.Service.MemberServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
//    private final DataSource dataSource;
//
////    @Autowired
//    public AppConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }


    @Bean
    public MemberService memberService (){
        return new MemberServiceImp(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
