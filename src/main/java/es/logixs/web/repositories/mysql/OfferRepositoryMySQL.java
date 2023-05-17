package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.Offer;
import es.logixs.web.repositories.OfferRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Repository
public class OfferRepositoryMySQL implements OfferRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Offer insert(Offer offer) {
        em.persist(offer);
        return offer;
    }

    @Override
    @Transactional
    public Offer update(Offer offer) {
        em.merge(offer);
        return offer;
    }

    @Override
    @Transactional
    public void delete(UUID objectId) {
        Offer offer = em.find(Offer.class, objectId);
        em.remove(offer);
    }

    @Override
    @Transactional
    public Offer findOne(UUID objectId) {
        return em.find(Offer.class, objectId);
    }

    @Override
    @Transactional
    public List<Offer> findAll() {
        return em.createQuery("SELECT o FROM Offer o", Offer.class).getResultList();
    }
}
