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

    private final static String sqlInsert = "insert into company (objectid,code,licenseId,name,taxId) values (?,?,?,?,?)";
    private final static String sqlFindAll = "select * from company";
    private final static String sqlDelete = "delete from company where objectid=?";
    private final static String sqlFindOne = "select * from company where objectid=?";
    private final static String sqlUpdate = "update company set objectId=?,code=? , licenseId=? , name=? ,taxId=? where objectid=?";
  
    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public Company insert(Company company) {
        plantilla.update(sqlInsert, company.getObjectId(),company.getCode(), company.getLicenseId(),company.getName(), company.getTaxId());
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
    public Company findOne(String objectid) {
       
       return  plantilla.queryForObject(sqlFindOne, new CompanyMapper(),objectid);
    }
    @Override
    public void update(Company company) {
      
        plantilla.update(sqlUpdate,company.getObjectId(), company.getCode(), company.getLicenseId(),company.getName(), company.getTaxId(),company.getObjectId());

    }
    @Override
    public void update(Company company, Company oldCompany) {
        
        plantilla.update(sqlUpdate,company.getObjectId(), company.getCode(), company.getLicenseId(),company.getName(), company.getTaxId(),oldCompany.getObjectId());
    }

}
