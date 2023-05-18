package es.logixs.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import es.logixs.web.dto.CompanyDTO;
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
    private UserCompanyService userCompanyService;

    @GetMapping
    public List<CompanyDTO> findAllCompanies() {
        List<CompanyDTO> listCompanyDto = new ArrayList<CompanyDTO>();

        for (Company company : userCompanyService.findAllCompanies()) {

            listCompanyDto.add(new CompanyDTO(company));
        }

        return listCompanyDto;
    }

    @GetMapping("/{objectId}")
    public CompanyDTO findOneCompany(@PathVariable String objectId) {
        return new CompanyDTO(userCompanyService.findOneCompany(UUID.fromString(objectId)));
    }

    @DeleteMapping("/{objectId}")
    public void deleteCompany(@PathVariable String objectId) {

        userCompanyService.deleteCompany(new Company(UUID.fromString(objectId)));
    }

    @PostMapping
    public Company insertCompany(@RequestBody CompanyDTO companyDto) {
        return userCompanyService.insertCompany(companyDto.createCompany());
    }

    @PutMapping("/{objectId}")
    public void updateCompany(@RequestBody CompanyDTO companyDto, @PathVariable String objectId) {
        userCompanyService.updateCompany(companyDto.createCompany(), UUID.fromString(objectId));
    }

}
