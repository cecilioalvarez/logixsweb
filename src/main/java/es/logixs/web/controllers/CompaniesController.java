package es.logixs.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{objectid}")
    public Companies findOneCompanies(@PathVariable String objectid) {
        return servicioUserCompany.findOneCompanies(objectid);
    }

  
   

}
