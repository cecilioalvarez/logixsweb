package es.logixs.web.repositories.mysql.mappers;

import es.logixs.web.domain.Request;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestMapper implements RowMapper<Request>{

    @Override
    public Request mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Request(rs.getString("id"), rs.getString("code"), rs.getString("offerId"), rs.getString("ownerId"), rs.getString("companyId"));
    }

}
