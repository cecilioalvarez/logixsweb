package es.logixs.web.controllers;

import es.logixs.web.domain.CounterOffer;
import es.logixs.web.services.OfferCounterofferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/counteroffer")
public class CounterOfferController {
    @Autowired
    private OfferCounterofferService offerCounterofferService;

    @GetMapping
    public List<CounterOffer> findAllCounterOffers() {
        return offerCounterofferService.findAllCounterOffers();
    }

    @GetMapping("/{objectId}")
    public CounterOffer findOneCounterOffer(@PathVariable String objectId) {
        return offerCounterofferService.findOneCounterOffer(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteCounterOffer(@PathVariable String objectId) {

        offerCounterofferService.deleteCounterOffer(new CounterOffer(objectId));
    }

    @PostMapping
    public CounterOffer insertCounterOffer(@RequestBody CounterOffer company) {
        return offerCounterofferService.insertCounterOffer(company);
    }

    @PutMapping("/{objectId}")
    public void updateCounterOffer(@RequestBody CounterOffer company, @PathVariable String objectId) {
        offerCounterofferService.updateCounterOffer(company, objectId);
    }

}
