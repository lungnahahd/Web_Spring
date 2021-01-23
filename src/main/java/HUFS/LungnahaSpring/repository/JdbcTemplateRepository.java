package HUFS.LungnahaSpring.repository;

import HUFS.LungnahaSpring.clientinfo.Member;
import com.sun.jdi.IntegerValue;
import com.sun.jdi.LongValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



public class JdbcTemplateRepository implements RepositoryInterface {
    // Jdbc는 해당 template이 필요
    // 자세한 JdbcTemplate의 사용은 반드시 찾아서 익히기
    private final JdbcTemplate jdbcTemplate;


    // 해당 template에 datasource를 넣어주기기
    @Autowired
   public JdbcTemplateRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Member save(Member member) {
        //해당 simpeljdbcinsert를 통해서 query문을 짜지 않고 입력 가능 -> Insert문을 대신해서 사용 가능
        //이렇게 하는 구나 정도로 알아두기
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name",member.getName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        member.setId(key.intValue());
        return member;
    }

    @Override
    public Optional<Member> findbyid(int id) {
        List<Member> result =  jdbcTemplate.query("select * from member where id = ?",memberRowMapper(),id);
        return  result.stream().findAny();
    }

    @Override
    public Optional<Member> findbyname(String name) {
        List<Member> result =  jdbcTemplate.query("select * from member where name = ?",memberRowMapper(), name);
        return  result.stream().findAny();
    }

    @Override
    public List<Member> findall() {
        return jdbcTemplate.query("select * from member",memberRowMapper());
    }

    // 결과를 RowMapping으로 맵핑 시켜줄 필요가 있음
    // 위에서 받은 결과에 따라 맵핑을 받아서 객체를 생성해주는 것
    private RowMapper<Member> memberRowMapper(){
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getInt("id"));
            member.setName(rs.getString("name"));
            return member;
        };
    }
}
