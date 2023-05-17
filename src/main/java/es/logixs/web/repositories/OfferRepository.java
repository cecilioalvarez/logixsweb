package es.logixs.web.repositories;

import es.logixs.web.domain.Offer;

import java.util.List;
import java.util.UUID;

public interface OfferRepository {

    Offer insert(Offer offer);

    Offer update(Offer offer);

    void delete(UUID objectId);

    Offer findOne(UUID objectId);

    List<Offer> findAll();
}