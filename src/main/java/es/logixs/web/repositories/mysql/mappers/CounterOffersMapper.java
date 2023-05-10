package es.logixs.web.repositories.mysql.mappers;

import es.logixs.web.domain.CounterOffers;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CounterOffersMapper implements RowMapper<CounterOffers> {
    @Override
    public CounterOffers mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CounterOffers(
                rs.getString("objectId"),
                rs.getString("name"),
                rs.getString("vom"),
                rs.getDouble("originalPrice"),
                rs.getDouble("counterOfferPrice"),
                rs.getDouble("quantity")
        );
    }
}