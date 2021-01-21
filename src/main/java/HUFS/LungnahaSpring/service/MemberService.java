package HUFS.LungnahaSpring.service;

import HUFS.LungnahaSpring.clientinfo.Member;
import HUFS.LungnahaSpring.repository.MemoryMember;
import HUFS.LungnahaSpring.repository.RepositoryInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private final RepositoryInterface memberRepository = new MemoryMember();
    private Object IllegalStateException;

    //회원가입 메소드 구현
    public int join(Member member){
        Optional<Member> result = memberRepository.findbyname(member.getName());
        int count = 0;
        try {
            while(count < memberRepository.findall().size(){
                if(memberRepository.findall().get(count).getName().equals(member.getName())){
                    throw new IllegalAccessException("동일한 아이디가 있습니다!");
                }
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        memberRepository.save(member);
        return member.getId();
    }

    //전체 회원 조회 서비스
    public List<Member> findAllMember(){
        return memberRepository.findall();
    }

    //이름 검색으로 회원 조외 서비스
    public Optional<Member> findOneMember(String name){
        return memberRepository.findbyname(name);
    }


}
