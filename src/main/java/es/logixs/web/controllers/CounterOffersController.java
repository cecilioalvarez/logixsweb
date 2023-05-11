package es.logixs.web.controllers;

import es.logixs.web.domain.CounterOffer;
import es.logixs.web.services.OfferCounterofferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/counteroffers")
public class CounterOffersController {
    @Autowired
    private OfferCounterofferService offerCounterofferService;

    @GetMapping
    public List<CounterOffer> findAllCounterOffers() {
        return offerCounterofferService.findAllCounterOffer();
    }

    @GetMapping("/{objectId}")
    public CounterOffer findOneCounterOffers(@PathVariable String objectId) {
        return offerCounterofferService.findOneCounterOffer(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteCounterOffers(@PathVariable String objectId) {

        offerCounterofferService.deleteCounterOffer(new CounterOffer(objectId));
    }

    @PostMapping
    public CounterOffer insertCounterOffers(@RequestBody CounterOffer company) {
        return offerCounterofferService.insertCounterOffer(company);
    }

    @PutMapping("/{objectId}")
    public void updateCounterOffers(@RequestBody CounterOffer company, @PathVariable String objectId) {
        offerCounterofferService.updateCounterOffer(company, objectId);
    }

}
