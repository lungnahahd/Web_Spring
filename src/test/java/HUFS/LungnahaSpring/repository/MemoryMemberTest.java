package HUFS.LungnahaSpring.repository;

import HUFS.LungnahaSpring.clientinfo.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberTest {
    MemoryMember repository = new MemoryMember();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Lungnaha");
        repository.save(member);

        //Member testcase = repository.findbyid(member.getId()).get();
        Member testcase = repository.findbyname("Lungnaha").get();
        Assertions.assertEquals(member,testcase);
        assertThat(member).isEqualTo(testcase);
    }
}
