package es.logixs.web.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;


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
    private UserCompanyService servicio;

    @Test
    void findAllCompaniesTest() throws Exception {

        Company company1 = new Company("1A", "1AC", "4321A", "PWC","1234A");
        Company company2 = new Company("2A", "2AC", "4321B", "IBERDROLA","1234B");
        Company company3 = new Company("3A", "3AC", "4321C", "MOVISTAR","1234C");


        List<Company> companyList = List.of(company1, company2, company3);
        when(servicio.findAllCompanies()).thenReturn(companyList);

        String listExpected = objectMapper.writeValueAsString(companyList);

        String companyListResultJSON = mvc.perform(get("/webapi/company")).andExpect(status().isOk())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(listExpected, companyListResultJSON);
    }

    @Test
    void findOneCompanyTest() throws Exception {

        Company company1 = new Company("1A", "1AC", "4321A", "PWC","1234A");

        when(servicio.findOneCompany("1A")).thenReturn(company1);

        String companyJsonResult = mvc.perform(get("/webapi/company/1A")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();

        String companyExpected = objectMapper.writeValueAsString(company1);

        assertEquals(companyExpected, companyJsonResult);
    }

    @Test
    void deleteCompanyTest() throws Exception {

        Company companyToDelete = new Company("1A");

        when(servicio.findOneCompany("1A")).thenReturn(companyToDelete);

        mvc.perform(delete("/webapi/company/1A"))
                .andExpect(status().isOk());

        verify(servicio, times(1)).deleteCompany(companyToDelete);

    }

    @Test
    void insertCompanyTest() throws Exception {

        Company company1 = new Company("1A", "1AC", "4321A", "PWC","1234A");

        when(servicio.insertCompany(company1)).thenReturn(company1);
        MvcResult result = mvc.perform(post("/webapi/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content( objectMapper.writeValueAsString(company1))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        String responseJson = result.getResponse().getContentAsString();
        Company createdCompany = objectMapper.readValue(responseJson, Company.class);
        assertEquals(company1, createdCompany);

        verify(servicio, times(1)).insertCompany(company1);

    }
}
