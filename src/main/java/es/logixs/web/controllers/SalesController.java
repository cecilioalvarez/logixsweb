package es.logixs.web.controllers;

import es.logixs.web.domain.Requests;
import es.logixs.web.domain.Sales;
import es.logixs.web.services.SalesProductsRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/sales")
public class SalesController {
    
    @Autowired
    private SalesProductsRequestsService salesProductsRequestsService;

    @GetMapping
    public List<Sales> findAllRequests() {
        return salesProductsRequestsService.findAllSales();
    }

    @GetMapping("/{objectId}")
    public Sales findOneSales(@PathVariable String objectId) {
        return salesProductsRequestsService.findOneSales(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteSales(@PathVariable String objectId) {
        salesProductsRequestsService.deleteSales(new Sales(objectId));
    }
    @PostMapping
    public Sales insertSales(@RequestBody Sales sale) {
        return salesProductsRequestsService.insertSales(sale);
    }
    @PutMapping("/{objectId}")
    public void updateSales(@RequestBody Sales sale,@PathVariable String objectId) {
        salesProductsRequestsService.updateSales(sale,objectId);
    }

  
   

}
