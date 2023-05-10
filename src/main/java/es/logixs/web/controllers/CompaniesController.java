package es.logixs.web.controllers;

import java.util.List;

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
@RequestMapping("webapi/companies")
public class CompaniesController {
    
    @Autowired
    private UserCompanyService servicioUserCompany;

    @GetMapping
    public List<Company> findAllCompanies() {
        return servicioUserCompany.findAllCompanies();
    }

    @GetMapping("/{objectId}")
    public Company findOneCompanies(@PathVariable String objectId) {
        return servicioUserCompany.findOneCompanies(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteCompanies(@PathVariable String objectId) {

        servicioUserCompany.deleteCompanies(new Company(objectId));
    }
    @PostMapping
    public Company insertCompanies(@RequestBody Company company) {
        return servicioUserCompany.insertCompanies(company);
    }
    @PutMapping("/{objectId}")
    public void updateCompanies(@RequestBody Company company, @PathVariable String objectId) {
        servicioUserCompany.updateCompanies(company,objectId);
    }

  
   

}
