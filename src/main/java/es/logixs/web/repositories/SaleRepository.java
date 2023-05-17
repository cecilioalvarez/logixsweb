package es.logixs.web.repositories;


import es.logixs.web.domain.Sale;

import java.util.List;
import java.util.UUID;

public interface SaleRepository {

    Sale insert(Sale sale);

    Sale findOne(UUID objectId);
    List<Sale> findAll();
    void delete(UUID objectId);
    void update(Sale sale);
    void update(Sale sale, Sale oldSale);
}


