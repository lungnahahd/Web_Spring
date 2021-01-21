package HUFS.LungnahaSpring.repository;

import HUFS.LungnahaSpring.clientinfo.Member;

import java.util.*;

//인터페이스에 제공되는 구현체
public class MemoryMember implements RepositoryInterface {
    private static Map<int, Member> infostore = new HashMap<>();
    private static int sequence = 0;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        infostore.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findbyid(int id) {
        return Optional.ofNullable(infostore.get(id));
    }

    @Override
    public Optional<Member> findbyname(String name) {
        Member find = new Member();
        for( Member value: infostore.values()){
            if(value.getName().equals(name)){
                find = value;
                break;
            }
        }
        return Optional.ofNullable(find);
        //람다식 구현
        /**
         * return infostore.values().stream()
         *          .filter(member -> member.getName().equals(name))
         *          .findAny();

         **/
    }

    @Override
    //ArrayList = List 인터페이스를 상속 받은 클래스로 크기가 가변적으로 변하는 선형 리스트
    public List<Member> findall() {
        //리스트 생성시 바로 값 추가 가능
        return new ArrayList<>(infostore.values())
    }
}
