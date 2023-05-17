package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.Product;
import es.logixs.web.repositories.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepositoryMySQL implements ProductRepository {
    @PersistenceContext
    EntityManager em;
    
    @Override
    @Transactional
    public Product insert(Product product) {
        em.persist(product);
        return product;
    }

    @Override
    public Product findOne(UUID objectId) {
        return em.find(Product.class, objectId);
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Transactional
    @Override
    public void delete(UUID objectId) {
        Product product = em.find(Product.class, objectId);
        if (product != null) {
            em.remove(product);
        }
    }

    @Override
    public Product update(Product product) {
        em.merge(product);
        return product;
    }

    @Override
    public Product update(Product product, Product oldProduct) {
        return null;
    }
}
