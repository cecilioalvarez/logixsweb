package es.logixs.web.controllers;

import es.logixs.web.domain.Sale;
import es.logixs.web.services.SaleProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/sales")
public class SalesController {
    
    @Autowired
    private SaleProductRequestService saleProductRequestService;

    @GetMapping
    public List<Sale> findAllRequests() {
        return saleProductRequestService.findAllSales();
    }

    @GetMapping("/{objectId}")
    public Sale findOneSales(@PathVariable String objectId) {
        return saleProductRequestService.findOneSales(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteSales(@PathVariable String objectId) {
        saleProductRequestService.deleteSales(new Sale(objectId));
    }
    @PostMapping
    public Sale insertSales(@RequestBody Sale sale) {
        return saleProductRequestService.insertSales(sale);
    }
    @PutMapping("/{objectId}")
    public void updateSales(@RequestBody Sale sale, @PathVariable String objectId) {
        saleProductRequestService.updateSales(sale,objectId);
    }

  
   

}
