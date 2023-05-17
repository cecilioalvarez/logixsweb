package es.logixs.web.services;

import es.logixs.web.domain.CounterOffer;
import es.logixs.web.domain.Offer;
import es.logixs.web.repositories.CounterOfferRepository;
import es.logixs.web.repositories.OfferRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class OfferCounterofferService {

    private final OfferRepository offerRepository;
    private final CounterOfferRepository counterOfferRepository;


    public OfferCounterofferService(OfferRepository offerRepository, CounterOfferRepository counterOfferRepository) {
        this.offerRepository = offerRepository;
        this.counterOfferRepository = counterOfferRepository;
    }

    public Offer insertOffer(Offer offer) {
        return offerRepository.insert(offer);
    }

    public void deleteOffer(UUID objectId) {
        offerRepository.delete(objectId);
    }

    public void updateOffer(Offer offer, UUID objectId) {
        offer.setObjectId(objectId);
        offerRepository.update(offer);
    }

    public Offer findOneOffer(UUID objectId) {
        return offerRepository.findOne(objectId);
    }

    public List<Offer> findAllOffers() {
        return offerRepository.findAll();
    }

    public CounterOffer insertCounterOffer(CounterOffer counterOffer) {
        return counterOfferRepository.insert(counterOffer);
    }

    public void updateCounterOffer(CounterOffer counterOffer, UUID objectId) {
        CounterOffer oldCounterOffer = counterOfferRepository.findOne(objectId);
        counterOfferRepository.update(counterOffer, oldCounterOffer);
    }

    public void deleteCounterOffer(UUID objectId) {
        counterOfferRepository.delete(objectId);
    }

    public CounterOffer findOneCounterOffer(UUID objectId) {
        return counterOfferRepository.findOne(objectId);
    }

    public List<CounterOffer> findAllCounterOffers() {
        return counterOfferRepository.findAll();
    }
}