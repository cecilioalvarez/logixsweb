package es.logixs.web.repositories.mysql.mappers;

import es.logixs.web.domain.Sale;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleMapper implements RowMapper<Sale> {

    @Override
    public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Sale(
                rs.getString("objectId"),
                rs.getString("ownerId"),
                rs.getString("clientId"),
                rs.getString("code"),
                rs.getString("offerId"),
                rs.getString("counterOfferId"),
                rs.getBoolean("isCounterOffer")
        );
    }
}