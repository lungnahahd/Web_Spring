package HUFS.LungnahaSpring.service;

import HUFS.LungnahaSpring.repository.JdbcTemplateRepository;
import HUFS.LungnahaSpring.repository.JpaMemberRepository;
import HUFS.LungnahaSpring.repository.MemoryMember;
import HUFS.LungnahaSpring.repository.RepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.swing.*;

//자바 코드로 직접 스프링 빈 등록하기 -> 인터페이스의 원활한 연결 가능
@Configuration
public class SpringConfig {
    //jdbc에서 사용
    //private DataSource dataSource;

    //스프링 데이터 jpa에서 사용
//    private final RepositoryInterface ri;
//    @Autowired
//    public SpringConfig(RepositoryInterface ri){
//        this.ri = ri;
//    }
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(ri);
//    }


//jpa에서 사용
    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }


    @Bean
    public  MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public RepositoryInterface memberRepository(){
        //return new MemoryMember();
        //return new JdbcTemplateRepository(dataSource);
        return  new JpaMemberRepository(em);
    }
}
