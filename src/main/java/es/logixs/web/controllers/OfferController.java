package es.logixs.web.controllers;

import es.logixs.web.domain.Offer;
import es.logixs.web.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/offer")
public class OfferController {
    
    @Autowired
    private OfferService offerService;
    
    @GetMapping()
    private List<Offer> findAllOffers() {
        return offerService.findAllOffers();
    }
    
    @GetMapping("/{objectId}")
    private Offer findOneOffer(@PathVariable String objectId) {
        return offerService.findOneOffer(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteOffer(@PathVariable String objectId) {
        offerService.deleteOffer(new Offer(objectId));
    }
    @PostMapping
    public Offer insertOffer(@RequestBody Offer sale) {
        return offerService.insertOffer(sale);
    }
    @PutMapping("/{objectId}")
    public void updateOffer(@RequestBody Offer sale,@PathVariable String objectId) {
        offerService.updateOffer(sale,objectId);
    }
    
    
}
