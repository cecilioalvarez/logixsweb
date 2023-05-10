package es.logixs.web.controllers;

import es.logixs.web.domain.CounterOffers;
import es.logixs.web.services.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/counteroffers")
public class CounterOffersController {
    @Autowired
    private OffersService offersService;

    @GetMapping
    public List<CounterOffers> findAllCounterOffers() {
        return offersService.findAllCounterOffer();
    }

    @GetMapping("/{objectId}")
    public CounterOffers findOneCounterOffers(@PathVariable String objectId) {
        return offersService.findOneCounterOffer(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteCounterOffers(@PathVariable String objectId) {

        offersService.deleteCounterOffer(new CounterOffers(objectId));
    }

    @PostMapping
    public CounterOffers insertCounterOffers(@RequestBody CounterOffers company) {
        return offersService.insertCounterOffer(company);
    }

    @PutMapping("/{objectId}")
    public void updateCounterOffers(@RequestBody CounterOffers company, @PathVariable String objectId) {
        offersService.updateCounterOffer(company, objectId);
    }

}
