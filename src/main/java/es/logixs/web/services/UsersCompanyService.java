package es.logixs.web.services;

import java.util.List;

import org.springframework.stereotype.Component;

import es.logixs.web.domain.Companies;
import es.logixs.web.repositories.CompaniesRepository;
@Component
public class UsersCompanyService {

 
   // private UserRepository repositorioUserMySQL;

   // un servicio tenga varios metodos que invocan a los repos
    public void updateCompanies(Companies company,String objectId) {
      //objeto viejo
       Companies companiesOld= repositorioCompaniesMySQL.findOne(objectId);
       companiesOld.setName(company.getName());
       companiesOld.setLicenseId(company.getLicenseId());
       companiesOld.setTaxId(company.getTaxId());
       companiesOld.setCode(company.getCode());
       companiesOld.setObjectId(company.getObjectId());
       repositorioCompaniesMySQL.update(companiesOld);
    }
    private CompaniesRepository repositorioCompaniesMySQL;


    public UsersCompanyService( CompaniesRepository repoCompanies) {
       // this.repositorioUserMySQL = repoUsers;
        this.repositorioCompaniesMySQL = repoCompanies;
    }

    // public void deleteUser(User user) {
    //     repositorioUserMySQL.delete(user);
    // }

    public void deleteCompanies(Companies company) {
        repositorioCompaniesMySQL.delete(company);
    }


    public Companies insertCompanies(Companies company) {
        return repositorioCompaniesMySQL.insert(company);
    }
    /*
    public User insertUser(User user) {
        return repositorioUserMySQL.insert(user);
    }
 */
    public List<Companies> findAllCompanies() {
        return repositorioCompaniesMySQL.findAll();
    }
    /*
    public List<User> findAllUsers() {
        return repositorioUserMySQL.findAll();
    }
 */
    public Companies findOneCompanies(String objectid) {
        return repositorioCompaniesMySQL.findOne(objectid);
    }
    /*
    public User findOneUser(String objectid) {
        return repositorioUserMySQL.findOne(objectid);
    }
 */



}
