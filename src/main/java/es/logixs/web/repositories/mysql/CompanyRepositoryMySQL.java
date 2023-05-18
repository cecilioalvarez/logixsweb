package es.logixs.web.repositories.mysql;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.logixs.web.domain.Company;
import es.logixs.web.repositories.CompanyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CompanyRepositoryMySQL implements CompanyRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Company insert(Company company) {
        em.persist(company);
        return company;
    }

    @Override
    @Transactional
    public void delete(Company company) {
        Company companyToDelete = em.find(Company.class, company.getObjectId());
        em.remove(companyToDelete);
    }

    @Override
    public List<Company> findAll() {
        return em.createQuery("select c from Company c ", Company.class).getResultList();
    }

    @Override
    public Company findOne(UUID objectId) {
        return em.find(Company.class, objectId);
    }

    @Override
    public void update(Company company) {
        em.merge(company);
    }

    @Override
    public void update(Company company, Company oldCompany) {

    }

}
