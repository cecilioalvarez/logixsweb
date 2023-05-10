package es.logixs.web.repositories;


import es.logixs.web.domain.Sales;

import java.util.List;

public interface SalesRepository {

    Sales insert(Sales sales);
    void update(Sales sales);
    Sales findOne(String id);
    List<Sales> findAll();
    void delete(Sales sales);

    void update(Sales sale, Sales oldSale);
}


