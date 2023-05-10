package es.logixs.web.controllers;

import es.logixs.web.domain.CounterOffer;
import es.logixs.web.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/counteroffers")
public class CounterOffersController {
    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<CounterOffer> findAllCounterOffers() {
        return offerService.findAllCounterOffer();
    }

    @GetMapping("/{objectId}")
    public CounterOffer findOneCounterOffers(@PathVariable String objectId) {
        return offerService.findOneCounterOffer(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteCounterOffers(@PathVariable String objectId) {

        offerService.deleteCounterOffer(new CounterOffer(objectId));
    }

    @PostMapping
    public CounterOffer insertCounterOffers(@RequestBody CounterOffer company) {
        return offerService.insertCounterOffer(company);
    }

    @PutMapping("/{objectId}")
    public void updateCounterOffers(@RequestBody CounterOffer company, @PathVariable String objectId) {
        offerService.updateCounterOffer(company, objectId);
    }

}
