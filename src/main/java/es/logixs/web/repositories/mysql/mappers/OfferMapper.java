package es.logixs.web.repositories.mysql.mappers;

import es.logixs.web.domain.Offer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferMapper implements RowMapper<Offer> {

    @Override
    public Offer mapRow(ResultSet rs, final int rowNum) throws SQLException {
        return  new Offer(
                rs.getString("objectId"),
                rs.getString("code"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("category"));
    }
}
