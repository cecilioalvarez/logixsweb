package es.logixs.web.controllers;

import es.logixs.web.domain.Companies;
import es.logixs.web.domain.Requests;
import es.logixs.web.services.SalesProductsRequestsService;
import es.logixs.web.services.UsersCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/requests")
public class RequestsController {
    
    @Autowired
    private SalesProductsRequestsService salesProductsRequestsService;

    @GetMapping
    public List<Requests> findAllRequests() {
        return salesProductsRequestsService.findAllRequests();
    }

    @GetMapping("/{objectId}")
    public Requests findOneCompanies(@PathVariable String objectId) {
        return salesProductsRequestsService.findOneRequests(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteRequests(@PathVariable String objectId) {
        salesProductsRequestsService.deleteRequests(new Requests(objectId));
    }
    @PostMapping
    public Requests insertRequests(@RequestBody Requests request) {
        return salesProductsRequestsService.insertRequests(request);
    }
    @PutMapping("/{objectId}")
    public void updateCompanies(@RequestBody Requests request,@PathVariable String objectId) {
        salesProductsRequestsService.updateRequests(request,objectId);
    }

  
   

}
