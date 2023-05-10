package es.logixs.web.repositories;


import es.logixs.web.domain.Products;

import java.util.List;

public interface ProductsRepository {

    Products insert(Products product);
    Products findOne(String id);
    List<Products> findAll();
    void delete(String id);
    Products update(Products product);
    Products update(Products product, Products oldProduct);
}
