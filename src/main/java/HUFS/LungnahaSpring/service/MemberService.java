package HUFS.LungnahaSpring.service;

import HUFS.LungnahaSpring.clientinfo.Member;
import HUFS.LungnahaSpring.repository.MemoryMember;
import HUFS.LungnahaSpring.repository.RepositoryInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private static final RepositoryInterface memberRepository = new MemoryMember();
    private Object IllegalStateException;

    //회원가입 메소드 구현
    public static int join(Member member){
        Optional<Member> result = memberRepository.findbyname(member.getName());
        int count = 0;
        try {
            while(count < memberRepository.findall().size()){
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
    public static List<Member> findAllMember(){
        return memberRepository.findall();
    }

    //아이디 검색으로 회원 조외 서비스
    public static Optional<Member> findOneMember(int id){
        return memberRepository.findbyid(id);
    }


}
