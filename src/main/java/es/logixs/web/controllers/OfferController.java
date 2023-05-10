package es.logixs.web.controllers;

import es.logixs.web.domain.Offer;
import es.logixs.web.services.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/offer")
public class OfferController {
    
    @Autowired
    private OffersService offersService;
    
    @GetMapping()
    private List<Offer> findAllOffers() {
        return offersService.findAllOffers();
    }
    
    @GetMapping("/{objectId}")
    private Offer findOneOffer(@PathVariable int objectId) {
        return offersService.findOneOffer(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteOffer(@PathVariable int objectId) {
        offersService.deleteOffer(new Offer(objectId));
    }
    @PostMapping
    public Offer insertOffer(@RequestBody Offer sale) {
        return offersService.insertOffer(sale);
    }
    @PutMapping("/{objectId}")
    public void updateOffer(@RequestBody Offer sale,@PathVariable int objectId) {
        offersService.updateOffer(sale,objectId);
    }
    
    
}
