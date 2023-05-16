package es.logixs.web.repositories.mysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.logixs.web.domain.Company;
import es.logixs.web.repositories.CompanyRepository;
import es.logixs.web.repositories.mysql.mappers.CompanyMapper;

@Repository
public class CompanyRepositoryMySQL implements CompanyRepository {

    private final static String sqlInsert = "insert into company (objectId,code,state,licenseId,limitUsers,name,address,phone," +
            "countryIso, taxId, url, createdAt, updatedAt) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final static String sqlFindAll = "select * from company";
    private final static String sqlDelete = "delete from company where objectId=?";
    private final static String sqlFindOne = "select * from company where objectId=?";
    private final static String sqlUpdate = "update company set objectId=?, code=?, state=?, licenseId=?, limitUsers=?, name=?, address=?, " +
            "taxId=?, url=?, createdAt=?, updatedAt=? where objectId=?";
  
    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public Company insert(Company company) {
        plantilla.update(
                sqlInsert,
                company.getObjectId(),
                company.getCode(),
                company.getState(),
                company.getLicenseId(),
                company.getLimitUsers(),
                company.getName(),
                company.getAddress(),
                company.getPhone(),
                company.getCountryIso(),
                company.getTaxId(),
                company.getUrl(),
                company.getCreateAt(),
                company.getUpdateAt());
        return company;
    }
    @Override
    public void delete(Company company) {
        plantilla.update(sqlDelete, company.getObjectId());
    }

    @Override
    public List<Company> findAll() {
        return plantilla.query(sqlFindAll, new CompanyMapper());
    }
    
    @Override
    public Company findOne(String objectId) {

       return  plantilla.queryForObject(sqlFindOne, new CompanyMapper(),objectId);
    }
    @Override
    public void update(Company company) {
      
        plantilla.update(
                sqlUpdate,
                company.getObjectId(),
                company.getCode(),
                company.getState(),
                company.getLicenseId(),
                company.getLimitUsers(),
                company.getName(),
                company.getAddress(),
                company.getPhone(),
                company.getCountryIso(),
                company.getTaxId(),
                company.getUrl(),
                company.getCreateAt(),
                company.getUpdateAt(),
                company.getObjectId());
    }
    @Override
    public void update(Company company, Company oldCompany) {
        
        plantilla.update(
                sqlUpdate,
                company.getObjectId(),
                company.getCode(),
                company.getState(),
                company.getLicenseId(),
                company.getLimitUsers(),
                company.getName(),
                company.getAddress(),
                company.getPhone(),
                company.getCountryIso(),
                company.getTaxId(),
                company.getUrl(),
                company.getCreateAt(),
                company.getUpdateAt(),
                oldCompany.getObjectId());
    }

}
