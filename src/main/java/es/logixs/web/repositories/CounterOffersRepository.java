package es.logixs.web.repositories;


import es.logixs.web.domain.CounterOffers;

import java.util.List;

public interface CounterOffersRepository {
    CounterOffers insert(CounterOffers counterOffer);

    void update(CounterOffers counterOffer);

    void update(CounterOffers counterOffer, CounterOffers oldCounterOffer);

    void delete(CounterOffers counterOffer);

    CounterOffers findOne(String objectId);

    List<CounterOffers> findAll();
}