package es.logixs.web.controllers;

import es.logixs.web.domain.Request;
import es.logixs.web.services.SaleProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/request")
public class RequestController {
    
    @Autowired
    private SaleProductRequestService saleProductRequestService;

    @GetMapping
    public List<Request> findAllRequests() {
        return saleProductRequestService.findAllRequests();
    }

    @GetMapping("/{objectId}")
    public Request findOneRequest(@PathVariable String objectId) {
        return saleProductRequestService.findOneRequest(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteRequest(@PathVariable String objectId) {
        saleProductRequestService.deleteRequest(new Request(objectId));
    }
    @PostMapping
    public Request insertRequest(@RequestBody Request request) {
        return saleProductRequestService.insertRequest(request);
    }
    @PutMapping("/{objectId}")
    public void updateRequest(@RequestBody Request request, @PathVariable String objectId) {
        saleProductRequestService.updateRequest(request,objectId);
    }

  
   

}
