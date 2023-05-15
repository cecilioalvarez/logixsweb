package es.logixs.web.controllers;

import java.util.ArrayList;
import java.util.List;

import es.logixs.web.domain.User;
import es.logixs.web.dto.CompanyDTO;
import es.logixs.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.logixs.web.domain.Company;
import es.logixs.web.services.UserCompanyService;

@RestController
@RequestMapping("webapi/company")
public class CompanyController {
    
    @Autowired
    private UserCompanyService servicioUserCompany;

    @GetMapping
    public List<CompanyDTO> findAllCompanies() {
        List<CompanyDTO> listCompanyDto= new ArrayList<CompanyDTO>();

        for (Company company: servicioUserCompany.findAllCompanies() ) {

            listCompanyDto.add(new CompanyDTO(company));
        }

        return listCompanyDto;
    }

    @GetMapping("/{objectId}")
    public CompanyDTO findOneCompany(@PathVariable String objectId) {
        return new CompanyDTO(servicioUserCompany.findOneCompany(objectId));
    }

    @DeleteMapping("/{objectId}")
    public void deleteCompany(@PathVariable String objectId) {

        servicioUserCompany.deleteCompany(new Company(objectId));
    }
    @PostMapping
    public Company insertCompany(@RequestBody CompanyDTO companyDto) {
        return servicioUserCompany.insertCompany(companyDto.createCompany());
    }
    @PutMapping("/{objectId}")
    public void updateCompany(@RequestBody CompanyDTO companyDto, @PathVariable String objectId) {
        servicioUserCompany.updateCompany(companyDto.createCompany(),objectId);
    }

  
   

}
