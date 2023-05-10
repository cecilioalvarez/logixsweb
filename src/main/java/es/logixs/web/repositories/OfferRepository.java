package es.logixs.web.repositories;

import es.logixs.web.domain.Offer;

import java.util.List;

public interface OfferRepository {

    Offer insert(Offer offer);
    Offer update(Offer offer);
    Offer update(Offer offer, Offer oldOffer);
    void delete(Offer offer);
    Offer findOne(int id);
    List<Offer> findAll();
}