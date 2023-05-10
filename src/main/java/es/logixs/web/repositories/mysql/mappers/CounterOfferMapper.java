package es.logixs.web.repositories.mysql.mappers;

import es.logixs.web.domain.CounterOffer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CounterOfferMapper implements RowMapper<CounterOffer> {
    @Override
    public CounterOffer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CounterOffer(
                rs.getString("objectId"),
                rs.getString("name"),
                rs.getString("vom"),
                rs.getDouble("originalPrice"),
                rs.getDouble("counterOfferPrice"),
                rs.getDouble("quantity")
        );
    }
}