package es.logixs.web.controllers;

import es.logixs.web.domain.Product;
import es.logixs.web.dto.ProductDTO;
import es.logixs.web.services.SaleProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("webapi/product")
public class ProductController {
    
    @Autowired
    private SaleProductRequestService saleProductRequestService;

    @GetMapping
    public List<ProductDTO> findAllProducts() {
        List<ProductDTO> listProductDto = new ArrayList<ProductDTO>();

        for (Product product: saleProductRequestService.findAllProducts() ) {
            listProductDto.add(new ProductDTO(product));
        }
        return listProductDto;
    }

    @GetMapping("/{objectId}")
    public ProductDTO findOneProduct(@PathVariable String objectId) {
        return new ProductDTO(saleProductRequestService.findOneProduct(UUID.fromString(objectId)));
    }

    @DeleteMapping("/{objectId}")
    public void deleteProduct(@PathVariable String objectId) {
        saleProductRequestService.deleteProduct(UUID.fromString(objectId));
    }
    @PostMapping
    public Product insertProduct(@RequestBody ProductDTO product) {
        return saleProductRequestService.insertProduct(product.createProduct());
    }
    @PutMapping("/{objectId}")
    public void updateProduct(@RequestBody ProductDTO product, @PathVariable String objectId) {
        saleProductRequestService.updateProduct(product.createProduct(), UUID.fromString(objectId));
    }

  
   

}
