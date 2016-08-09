package spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static long nextId = 0;

    private Map<String, Member> map = new HashMap<>();

    public Member selectByEmail(String email) {
        List<Member> members = jdbcTemplate.query(
                "SELECT * FROM member WHERE email = ?",
                (rs, rowNum) -> {
                    Member member = new Member(
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getTimestamp("regdate")
                    );

                    member.setId(rs.getLong("id"));
                    return member;
                },
                email
        );

        return members.isEmpty() ? null : members.get(0);
    }

    public void insert(Member member) {
        member.setId(++nextId);
        map.put(member.getEmail(), member);
    }

    public void update(Member member) {
        map.put(member.getEmail(), member);
    }

    public Collection<Member> selectAll() {
        return map.values();
    }

}
