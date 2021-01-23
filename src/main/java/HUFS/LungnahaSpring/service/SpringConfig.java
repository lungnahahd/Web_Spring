package HUFS.LungnahaSpring.service;

import HUFS.LungnahaSpring.repository.MemoryMember;
import HUFS.LungnahaSpring.repository.RepositoryInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//자바 코드로 직접 스프링 빈 등록하기 -> 인터페이스의 원활한 연결 가능
@Configuration
public class SpringConfig {
    @Bean
    public  MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public RepositoryInterface memberRepository(){
        return new MemoryMember();
    }
}
