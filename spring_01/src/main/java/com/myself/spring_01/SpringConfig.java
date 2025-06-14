package com.myself.spring_01;


import com.myself.spring_01.repository.JdbcMemberRepository;
import com.myself.spring_01.repository.JpaMemberRepository;
import com.myself.spring_01.repository.MemberRepository;
import com.myself.spring_01.repository.MemoryMemberRepository;
import com.myself.spring_01.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }



}
