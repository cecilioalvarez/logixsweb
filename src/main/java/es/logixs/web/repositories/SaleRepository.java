package es.logixs.web.repositories;


import es.logixs.web.domain.Sale;

import java.util.List;

public interface SaleRepository {

    Sale insert(Sale sale);
    void update(Sale sale);
    Sale findOne(String objectId);
    List<Sale> findAll();
    void delete(Sale sale);

    void update(Sale sale, Sale oldSale);
}


