package es.logixs.web;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import es.logixs.web.domain.Company;
import es.logixs.web.repositories.CompanyRepository;

@SpringBootTest
@Sql({ "classpath:schemacompanies.sql", "classpath:datacompanies.sql" })
class CompanyRepositoryTest {

    @Autowired
    private  CompanyRepository companiesRepository;

    

    @BeforeEach
    public void inicializar() throws IOException {

    
    }
    @Test
    void findOne() {
        Company companyFinal;
        companyFinal = companiesRepository.findOne("1A");
        assertEquals("PWC", companyFinal.getName());
    }

    @Test
    void findAll() {
        List<Company> lista = companiesRepository.findAll();
        assertTrue(lista.size()>=4);
    }
    @Test
    void insert() {
        Company company = new Company("6A", "32234", "ADF2323SD", "PWC DTS", "adsf23");
        Company companyFinal = companiesRepository.insert(company);
        assertEquals(company, companyFinal);
    }

    @Test
    void delete() {
        Company company = new Company("6A", "32234", "ADF2323SD", "PWC DTS", "adsf23");
        companiesRepository.insert(company);
        companiesRepository.delete(company);
       List<Company> companies = companiesRepository.findAll();
       assertFalse(companies.contains(company));

    }

}

