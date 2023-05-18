package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.Sale;
import es.logixs.web.repositories.SaleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Repository
public class SaleRepositoryMySQL implements SaleRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Sale insert(Sale sale) {
        em.persist(sale);
        return sale;
    }

    @Override
    @Transactional
    public void delete(UUID objectId) {
        Sale saleToDelete = em.find(Sale.class, objectId);
        em.remove(saleToDelete);
    }

    @Override
    public List<Sale> findAll() {
        return em.createQuery("select s from Sale s", Sale.class).getResultList();
    }

    @Override
    public Sale findOne(UUID objectId) {
       return em.find(Sale.class, objectId);
    }

    @Override
    @Transactional
    public void update(Sale sale) {
        em.merge(sale);
    }
    @Override
    public void update(Sale sale, Sale oldSale) { }

}
