package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.CounterOffer;
import es.logixs.web.repositories.CounterOfferRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;


@Component
public class CounterOfferRepositoryMySQL implements CounterOfferRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public CounterOffer findOne(UUID objectId) {
        return entityManager.find(CounterOffer.class, objectId);
    }

    @Override
    public List<CounterOffer> findAll() {
        return entityManager.createQuery("select counterOffer from CounterOffer counterOffer ", CounterOffer.class).getResultList();
    }

    @Override
    @Transactional
    public CounterOffer insert(CounterOffer counterOffer) {
        entityManager.persist(counterOffer);
        return counterOffer;
    }

    @Override
    @Transactional
    public void delete(UUID objectId) {
        CounterOffer counterOfferToDelete= entityManager.find(CounterOffer.class, objectId);
        entityManager.remove(counterOfferToDelete);
    }

    @Override
    @Transactional
    public void update(CounterOffer counterOffer) {
        entityManager.merge(counterOffer);
    }

    @Override
    public void update(CounterOffer counterOffer, CounterOffer oldCounterOffer) {
        // TODO
    }
}