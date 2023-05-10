package es.logixs.web.repositories;


import es.logixs.web.domain.CounterOffer;

import java.util.List;

public interface CounterOfferRepository {
    CounterOffer insert(CounterOffer counterOffer);

    void update(CounterOffer counterOffer);

    void update(CounterOffer counterOffer, CounterOffer oldCounterOffer);

    void delete(CounterOffer counterOffer);

    CounterOffer findOne(String objectId);

    List<CounterOffer> findAll();
}