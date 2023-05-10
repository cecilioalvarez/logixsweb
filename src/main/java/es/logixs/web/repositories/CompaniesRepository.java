package es.logixs.web.repositories;


import java.util.List;

import es.logixs.web.domain.Companies;

public interface CompaniesRepository {

    Companies insert(Companies company);
    void update(Companies company);
    void update(Companies company, Companies oldCompany);
    void delete(Companies company);
    List<Companies> findAll();

    Companies findOne(String objectid);

}
