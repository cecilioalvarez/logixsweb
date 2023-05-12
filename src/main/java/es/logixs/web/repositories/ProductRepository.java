package es.logixs.web.repositories;


import es.logixs.web.domain.Product;

import java.util.List;

public interface ProductRepository {

    Product insert(Product product);
    Product findOne(String objectId);
    List<Product> findAll();
    void delete(String objectId);
    Product update(Product product);
    Product update(Product product, Product oldProduct);
}
