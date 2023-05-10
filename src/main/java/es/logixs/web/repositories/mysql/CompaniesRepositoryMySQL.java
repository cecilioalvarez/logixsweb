package es.logixs.web.repositories.mysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.logixs.web.domain.Companies;
import es.logixs.web.repositories.CompaniesRepository;
import es.logixs.web.repositories.mysql.mappers.CompaniesMapper;

@Repository
public class CompaniesRepositoryMySQL implements CompaniesRepository {

    private final static String sqlInsert = "insert into companies (objectid,code,licenseId,name,taxId) values (?,?,?,?,?)";
    private final static String sqlFindAll = "select * from companies";
    private final static String sqlDelete = "delete from companies where objectid=?";
    private final static String sqlFindOne = "select * from companies where objectid=?";
    private final static String sqlUpdate = "update companies set objectId=?,code=? , licenseId=? , name=? ,taxId=? where objectid=?";
  
    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public Companies insert(Companies company) {   
        plantilla.update(sqlInsert, company.getObjectId(),company.getCode(), company.getLicenseId(),company.getName(), company.getTaxId());
        return company;
    }
    @Override
    public void delete(Companies company) {
        plantilla.update(sqlDelete, company.getObjectId());
    }

    @Override
    public List<Companies> findAll() {
        return plantilla.query(sqlFindAll, new CompaniesMapper());
    }
    
    @Override
    public Companies findOne(String objectid) {    
       
       return  plantilla.queryForObject(sqlFindOne, new CompaniesMapper(),objectid);
    }
    @Override
    public void update(Companies company) {
      
        plantilla.update(sqlUpdate,company.getObjectId(), company.getCode(), company.getLicenseId(),company.getName(), company.getTaxId(),company.getObjectId());

    }

}
