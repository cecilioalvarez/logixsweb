package es.logixs.web.services;

import es.logixs.web.domain.CounterOffers;
import es.logixs.web.domain.Requests;
import es.logixs.web.repositories.CounterOffersRepository;
import es.logixs.web.domain.Offer;
import es.logixs.web.repositories.OfferRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OffersService {

    private final OfferRepository offerRepository;
    private final CounterOffersRepository counterOffersRepository;


    public OffersService(OfferRepository offerRepository, CounterOffersRepository counterOffersRepository) {
        this.offerRepository = offerRepository;
        this.counterOffersRepository = counterOffersRepository;
    }

    public Offer insertOffer(Offer offer){
        return offerRepository.insert(offer);
    }

    public void deleteOffer(Offer offer){
        offerRepository.delete(offer);
    }

    public Offer findOneOffer(int objectId){
        return offerRepository.findOne(objectId);
    }

    public List<Offer> findAllOffers(){
        return offerRepository.findAll();
    }

    public CounterOffers insertCounterOffer(CounterOffers counterOffers){
        return counterOffersRepository.insert(counterOffers);
    }

    public CounterOffers updateCounterOffer(CounterOffers counterOffers,String objectId){
        CounterOffers oldCounterOffers= counterOffersRepository.findOne(objectId);
        counterOffersRepository.update(counterOffers,oldCounterOffers);
    }

    public void deleteCounterOffer(CounterOffers counterOffers){
        counterOffersRepository.delete(counterOffers);
    }

    public CounterOffers findOneCounterOffer(String objectId){
        return counterOffersRepository.findOne(objectId);
    }

    public List<CounterOffers> findAllCounterOffer(){
        return counterOffersRepository.findAll();
    }
}