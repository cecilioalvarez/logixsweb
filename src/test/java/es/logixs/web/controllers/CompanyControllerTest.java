package es.logixs.web.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.logixs.web.domain.Company;
import es.logixs.web.services.UserCompanyService;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class CompanyControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private UserCompanyService service;

    @Test
    void findAllCompaniesTest() throws Exception {

        Company company1 = new Company(UUID.randomUUID(), "code1", "state1", "licenseId1", 30, "name1", "address1",
                "phone1", "CISO1", "taxId1", "url1", new Date(), new Date());
        Company company2 = new Company(UUID.randomUUID(), "code2", "state2", "licenseId2", 40, "name2", "address2",
                "phone2", "CISO2", "taxId2", "url2", new Date(), new Date());
        Company company3 = new Company(UUID.randomUUID(), "code3", "state3", "licenseId3", 28, "name3", "address3",
                "phone3", "CISO3", "taxId3", "url3", new Date(), new Date());

        List<Company> companyList = List.of(company1, company2, company3);
        when(service.findAllCompanies()).thenReturn(companyList);

        String listExpected = objectMapper.writeValueAsString(companyList);

        String companyListResultJSON = mvc.perform(get("/webapi/company")).andExpect(status().isOk())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(listExpected, companyListResultJSON);
    }

    @Test
    void findOneCompanyTest() throws Exception {

        Company company1 = new Company(UUID.randomUUID(), "code3", "state3", "licenseId3", 28, "name3", "address3",
                "phone3", "CISO3", "taxId3", "url3", new Date(), new Date());

        when(service.findOneCompany(company1.getObjectId())).thenReturn(company1);

        String companyJsonResult = mvc.perform(get("/webapi/company/" + company1.getObjectId()))
                .andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();

        String companyExpected = objectMapper.writeValueAsString(company1);

        assertEquals(companyExpected, companyJsonResult);
    }

    @Test
    void deleteCompanyTest() throws Exception {

        Company companyToDelete = new Company(UUID.randomUUID());

        when(service.findOneCompany(companyToDelete.getObjectId())).thenReturn(companyToDelete);

        mvc.perform(delete("/webapi/company/" + companyToDelete.getObjectId()))
                .andExpect(status().isOk());

        verify(service, times(1)).deleteCompany(companyToDelete);

    }

    @Test
    void insertCompanyTest() throws Exception {

        Company company1 = new Company(UUID.randomUUID(), "code3", "state3", "licenseId3", 28, "name3", "address3",
                "phone3", "CISO3", "taxId3", "url3", new Date(), new Date());

        when(service.insertCompany(company1)).thenReturn(company1);
        MvcResult result = mvc.perform(post("/webapi/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(company1))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        String responseJson = result.getResponse().getContentAsString();
        Company createdCompany = objectMapper.readValue(responseJson, Company.class);
        assertEquals(company1, createdCompany);

        verify(service, times(1)).insertCompany(company1);

    }
}
