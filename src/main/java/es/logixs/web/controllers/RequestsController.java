package es.logixs.web.controllers;

import es.logixs.web.domain.Request;
import es.logixs.web.services.SaleProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/requests")
public class RequestsController {
    
    @Autowired
    private SaleProductRequestService saleProductRequestService;

    @GetMapping
    public List<Request> findAllRequests() {
        return saleProductRequestService.findAllRequests();
    }

    @GetMapping("/{objectId}")
    public Request findOneCompanies(@PathVariable String objectId) {
        return saleProductRequestService.findOneRequests(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteRequests(@PathVariable String objectId) {
        saleProductRequestService.deleteRequests(new Request(objectId));
    }
    @PostMapping
    public Request insertRequests(@RequestBody Request request) {
        return saleProductRequestService.insertRequests(request);
    }
    @PutMapping("/{objectId}")
    public void updateCompanies(@RequestBody Request request, @PathVariable String objectId) {
        saleProductRequestService.updateRequests(request,objectId);
    }

  
   

}
