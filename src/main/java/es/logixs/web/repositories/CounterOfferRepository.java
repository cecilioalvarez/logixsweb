package es.logixs.web.repositories;


import es.logixs.web.domain.CounterOffer;

import java.util.List;
import java.util.UUID;

public interface CounterOfferRepository {
    CounterOffer findOne(UUID objectId);

    List<CounterOffer> findAll();

    CounterOffer insert(CounterOffer counterOffer);

    void delete(UUID objectId);

    void update(CounterOffer counterOffer);

    void update(CounterOffer counterOffer, CounterOffer oldCounterOffer);
}