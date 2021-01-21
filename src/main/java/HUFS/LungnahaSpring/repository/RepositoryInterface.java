package HUFS.LungnahaSpring.repository;


import HUFS.LungnahaSpring.clientinfo.Member;

import java.util.List;
import java.util.Optional;

//나중에 DB가 선정된 후에 해당 interface를 연결만 해주면 나머지 코드를 건들지 않고 DB와 연결 가능
public interface RepositoryInterface {
    //(반환 타입) (함수명) 으로 적어주기
    Member save(Member member);
    Optional<Member> findbyid(int id);
    Optional<Member> findbyname(String name);
    List<Member> findall();
}
