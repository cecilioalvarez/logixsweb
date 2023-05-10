package es.logixs.web.controllers;

import es.logixs.web.domain.Products;
import es.logixs.web.domain.Requests;
import es.logixs.web.services.SalesProductsRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/products")
public class ProductsController {
    
    @Autowired
    private SalesProductsRequestsService salesProductsRequestsService;

    @GetMapping
    public List<Products> findAllProducts() {
        return salesProductsRequestsService.findAllProducts();
    }

    @GetMapping("/{objectId}")
    public Products findOneProduct(@PathVariable String objectId) {
        return salesProductsRequestsService.findOneProducts(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteProducts(@PathVariable String objectId) {
        salesProductsRequestsService.deleteProducts(objectId);
    }
    @PostMapping
    public Products insertProducts(@RequestBody Products product) {
        return salesProductsRequestsService.insertProducts(product);
    }
    @PutMapping("/{objectId}")
    public void updateProducts(@RequestBody Products product,@PathVariable String objectId) {
        salesProductsRequestsService.updateProducts(product,objectId);
    }

  
   

}
