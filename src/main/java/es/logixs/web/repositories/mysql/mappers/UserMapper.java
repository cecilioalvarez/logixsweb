package es.logixs.web.repositories.mysql.mappers;

import es.logixs.web.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getString("objectId"),
                rs.getString("name"),
                rs.getString("lastName"),
                rs.getString("email")
        );
    }
}
