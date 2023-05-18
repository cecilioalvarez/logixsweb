package es.logixs.web.repositories;


import es.logixs.web.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {

    Product insert(Product product);
    Product findOne(UUID objectId);
    List<Product> findAll();
    void delete(UUID objectId);
    Product update(Product product);
    Product update(Product product, Product oldProduct);
}
