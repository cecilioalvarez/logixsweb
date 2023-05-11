package es.logixs.web.controllers;

import es.logixs.web.domain.Product;
import es.logixs.web.services.SaleProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/product")
public class ProductController {
    
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
    public void deleteProduct(@PathVariable String objectId) {
        saleProductRequestService.deleteProduct(objectId);
    }
    @PostMapping
    public Product insertProduct(@RequestBody Product product) {
        return saleProductRequestService.insertProduct(product);
    }
    @PutMapping("/{objectId}")
    public void updateProduct(@RequestBody Product product, @PathVariable String objectId) {
        saleProductRequestService.updateProduct(product,objectId);
    }

  
   

}
