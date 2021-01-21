package HUFS.LungnahaSpring.service;

import HUFS.LungnahaSpring.clientinfo.Member;
import HUFS.LungnahaSpring.repository.MemoryMember;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.channels.MembershipKey;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    @Test
    void 회원가입test() {
//        //given
//        Member member = new Member();
//        member.setName("Lungnaha");
//        //when
//        int joinresult = MemberService.join(member);
//        //then
//        Member getresult = MemberService.findOneMember(joinresult).get();
//        assertEquals(member,getresult);

        Member sample1 = new Member();
        sample1.setName("Lungnaha");

        Member sample2 = new Member();
        sample2.setName("Lungnaha");
        //when
        MemberService.join(sample1);
        try {
            MemberService.join(sample2);
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("동일한 아이디가 있습니다!");
        }
    }



    @Test
    void findAllMember() {
    }

    @Test
    void findOneMember() {
    }
}