package es.logixs.web.repositories.mysql.mappers;

import es.logixs.web.domain.Requests;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestsMapper implements RowMapper<Requests>{

    @Override
    public Requests mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Requests(rs.getString("code"), rs.getString("offerId"), rs.getString("ownerId"), rs.getString("companyId"));
    }

}
