package es.logixs.web.repositories;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import es.logixs.web.domain.Company;

@SpringBootTest
@Sql({ "classpath:schemacompanies.sql", "classpath:datacompanies.sql" })
class CompanyRepositoryTest {

    @Autowired
    private  CompanyRepository companiesRepository;

    

    @Test
    void findOne() {
        Company companyFinal;
        companyFinal = companiesRepository.findOne("1A");
        assertEquals("name1", companyFinal.getName());
    }

    @Test
    void findAll() {
        List<Company> lista = companiesRepository.findAll();
        assertTrue(lista.size()>=4);
    }
    @Test
    void insert() {
        Company company = new Company("yyy", "code13", "state13", "licenseId13", 21, "name31", "address13", "phone13", "CISO13", "taxId13", "url13", null, null);
        Company companyFinal = companiesRepository.insert(company);
        assertEquals(company, companyFinal);
    }

    @Test
    void delete() {
        Company company = new Company("yyy", "code13", "state13", "licenseId13", 21, "name31", "address13", "phone13", "CISO13", "taxId13", "url13", null, null);
        companiesRepository.insert(company);
        companiesRepository.delete(company);
       List<Company> companies = companiesRepository.findAll();
       assertFalse(companies.contains(company));

    }

}

