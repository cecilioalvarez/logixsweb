package es.logixs.web.services;

import java.util.List;

import es.logixs.web.domain.User;
import es.logixs.web.repositories.UserRepository;
import org.springframework.stereotype.Component;

import es.logixs.web.domain.Company;
import es.logixs.web.repositories.CompanyRepository;
@Component
public class UserCompanyService {

 
   private final UserRepository userRepository;
   private final CompanyRepository companyRepository;

    public void updateCompanies(Company company, String objectId) {
       Company companiesOld= companyRepository.findOne(objectId);
       companyRepository.update(company,companiesOld);
    }


    public UserCompanyService(CompanyRepository repoCompanies, UserRepository repoUsers) {
        this.userRepository = repoUsers;
        this.companyRepository = repoCompanies;
    }
    public void updateUser(User user,String objectId) {
        User userOld= userRepository.findOne(objectId);
        userRepository.update(user,userOld);
    }
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void deleteCompanies(Company company) {
        companyRepository.delete(company);
    }


    public Company insertCompanies(Company company) {
        return companyRepository.insert(company);
    }

    public User insertUser(User user) {
        return userRepository.insert(user);
    }

    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Company findOneCompanies(String objectid) {
        return companyRepository.findOne(objectid);
    }

    public User findOneUser(String objectid) {
        return userRepository.findOne(objectid);
    }




}
