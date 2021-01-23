package HUFS.LungnahaSpring.clientinfo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//jpa 맵핑을 위해서 사용
@Entity
// 회원 객체를 만드는 클래스 구현
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
