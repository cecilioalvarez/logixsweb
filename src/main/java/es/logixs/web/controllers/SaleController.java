package es.logixs.web.controllers;

import es.logixs.web.domain.Sale;
import es.logixs.web.services.SaleProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/sale")
public class SaleController {
    
    @Autowired
    private SaleProductRequestService saleProductRequestService;

    @GetMapping
    public List<Sale> findAllSales() {
        return saleProductRequestService.findAllSales();
    }

    @GetMapping("/{objectId}")
    public Sale findOneSale(@PathVariable String objectId) {
        return saleProductRequestService.findOneSale(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteSale(@PathVariable String objectId) {
        saleProductRequestService.deleteSale(new Sale(objectId));
    }
    @PostMapping
    public Sale insertSale(@RequestBody Sale sale) {
        return saleProductRequestService.insertSale(sale);
    }
    @PutMapping("/{objectId}")
    public void updateSale(@RequestBody Sale sale, @PathVariable String objectId) {
        saleProductRequestService.updateSale(sale,objectId);
    }

  
   

}
