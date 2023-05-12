package es.logixs.web.repositories.mysql.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.logixs.web.domain.Company;

public class CompanyMapper implements RowMapper<Company> {

    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Company(
                rs.getString("objectId"),
                rs.getString("code"),
                rs.getString("licenseId"),
                rs.getString("name"),
                rs.getString("taxId")
        );
    }
}
