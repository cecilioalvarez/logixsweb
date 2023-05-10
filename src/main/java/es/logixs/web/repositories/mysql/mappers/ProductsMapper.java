package es.logixs.web.repositories.mysql.mappers;

import es.logixs.web.domain.Products;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductsMapper implements RowMapper<Products> {
    @Override
    public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Products(rs.getString("id"),rs.getString("userId"), rs.getString("code"), rs.getString("companyId"), rs.getString("scientificName"), rs.getString("name"), rs.getString("category"), rs.getString("originCountryIso"), rs.getString("quality"), rs.getString("descAndSpecs"));
    }
}
