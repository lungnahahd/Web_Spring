package HUFS.LungnahaSpring.repository;

import HUFS.LungnahaSpring.clientinfo.Member;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class JpaMemberRepository implements RepositoryInterface {

    //jpa는 entityManager를 이용해서 동작
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        //persist를 통해서 저장 가능
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findbyid(int id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findbyname(String name) {
        // :이름1 으로 파라미터 바인딩 실시 뒤에 이름1변수에 name을 집어넣는 것
        List<Member> result = em.createQuery("select m from Member m where m.name = :name",Member.class).setParameter("name",name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findall() {
        // jpa는 테이블 자체를 받지 않고 entity(객체) 자체를 받으면 알아서 이를 sql query문으로 바꾸어서 처리
        List<Member> result = em.createQuery("select m from Member m",Member.class).getResultList();
        return result;
    }
}
