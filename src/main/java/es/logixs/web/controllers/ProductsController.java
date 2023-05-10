package es.logixs.web.controllers;

import es.logixs.web.domain.Product;
import es.logixs.web.services.SaleProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/products")
public class ProductsController {
    
    @Autowired
    private SaleProductRequestService saleProductRequestService;

    @GetMapping
    public List<Product> findAllProducts() {
        return saleProductRequestService.findAllProducts();
    }

    @GetMapping("/{objectId}")
    public Product findOneProduct(@PathVariable String objectId) {
        return saleProductRequestService.findOneProducts(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteProducts(@PathVariable String objectId) {
        saleProductRequestService.deleteProducts(objectId);
    }
    @PostMapping
    public Product insertProducts(@RequestBody Product product) {
        return saleProductRequestService.insertProducts(product);
    }
    @PutMapping("/{objectId}")
    public void updateProducts(@RequestBody Product product, @PathVariable String objectId) {
        saleProductRequestService.updateProducts(product,objectId);
    }

  
   

}
