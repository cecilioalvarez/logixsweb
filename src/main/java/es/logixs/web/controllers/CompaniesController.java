package es.logixs.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.logixs.web.domain.Companies;
import es.logixs.web.services.UsersCompanyService;

@RestController
@RequestMapping("webapi/companies")
public class CompaniesController {
    
    @Autowired
    private UsersCompanyService servicioUserCompany;

    @GetMapping
    public List<Companies> findAllCompanies() {
        return servicioUserCompany.findAllCompanies();
    }

    @GetMapping("/{objectId}")
    public Companies findOneCompanies(@PathVariable String objectId) {
        return servicioUserCompany.findOneCompanies(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteCompanies(@PathVariable String objectId) {

        servicioUserCompany.deleteCompanies(new Companies(objectId));
    }
    @PostMapping
    public Companies insertCompanies(@RequestBody Companies company) {
        return servicioUserCompany.insertCompanies(company);
    }

  
   

}
