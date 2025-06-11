package com.myself.spring_01;


import com.myself.spring_01.repository.MemberRepository;
import com.myself.spring_01.repository.MemoryMemberRepository;
import com.myself.spring_01.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
