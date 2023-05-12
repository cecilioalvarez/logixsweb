package es.logixs.web.repositories;


import java.util.List;

import es.logixs.web.domain.Company;

public interface CompanyRepository {

    Company insert(Company company);
    void update(Company company);
    void update(Company company, Company oldCompany);
    void delete(Company company);
    List<Company> findAll();

    Company findOne(String objectId);

}
