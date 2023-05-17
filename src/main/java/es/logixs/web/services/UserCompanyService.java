package es.logixs.web.services;

import java.util.List;
import java.util.UUID;

import es.logixs.web.domain.User;
import es.logixs.web.repositories.UserRepository;
import org.springframework.stereotype.Component;

import es.logixs.web.domain.Company;
import es.logixs.web.repositories.CompanyRepository;

@Component
public class UserCompanyService {


    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public UserCompanyService(CompanyRepository companyRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    public void updateCompany(Company company, String objectId) {
        Company companyOld = companyRepository.findOne(objectId);
        companyRepository.update(company, companyOld);
    }


    public void updateUser(User user, UUID objectId) {
        User userOld = userRepository.findOne(objectId);
        userRepository.update(user, userOld);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void deleteCompany(Company company) {
        companyRepository.delete(company);
    }

    public Company insertCompany(Company company) {
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

    public Company findOneCompany(String objectId) {
        return companyRepository.findOne(objectId);
    }

    public User findOneUser(UUID objectId) {
        return userRepository.findOne(objectId);
    }
}
