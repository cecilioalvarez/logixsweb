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
@RequestMapping("webapi/company")
public class CompanyController {
    
    @Autowired
    private UserCompanyService servicioUserCompany;

    @GetMapping
    public List<Company> findAllCompanies() {
        return servicioUserCompany.findAllCompanies();
    }

    @GetMapping("/{objectId}")
    public Company findOneCompany(@PathVariable String objectId) {
        return servicioUserCompany.findOneCompany(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteCompany(@PathVariable String objectId) {

        servicioUserCompany.deleteCompany(new Company(objectId));
    }
    @PostMapping
    public Company insertCompany(@RequestBody Company company) {
        return servicioUserCompany.insertCompany(company);
    }
    @PutMapping("/{objectId}")
    public void updateCompany(@RequestBody Company company, @PathVariable String objectId) {
        servicioUserCompany.updateCompany(company,objectId);
    }

  
   

}
