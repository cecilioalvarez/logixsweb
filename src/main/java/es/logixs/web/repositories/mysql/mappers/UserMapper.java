/*
package es.logixs.web.repositories.mysql.mappers;

import es.logixs.web.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getString("objectId"),
                rs.getString("name"),
                rs.getString("lastName"),
                rs.getString("email"),
                rs.getString("state"),
                rs.getString("avatar"),
                rs.getString("password"),
                rs.getString("prevPasswords"),
                rs.getString("companyId"),
                rs.getString("invitedBy"),
                rs.getString("role"),
                rs.getDouble("limitAmount"),
                rs.getString("address"),
                rs.getString("phone"),
                rs.getString("city"),
                rs.getString("zipCode"),
                rs.getString("countryIso"),
                rs.getDate("createdAt"),
                rs.getDate("updatedAt")
        );
    }
}
*/