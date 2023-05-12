package es.logixs.web.repositories.mysql.mappers;

import es.logixs.web.domain.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
                rs.getString("objectId"),
                rs.getString("userId"),
                rs.getString("code"),
                rs.getString("companyId"),
                rs.getString("scientificName"),
                rs.getString("name"),
                rs.getString("category"),
                rs.getString("originCountryIso"),
                rs.getString("quality"),
                rs.getString("descAndSpecs")
        );
    }
}
