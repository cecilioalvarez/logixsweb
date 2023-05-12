package es.logixs.web.controllers;

import es.logixs.web.domain.Offer;
import es.logixs.web.services.OfferCounterofferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/offer")
public class OfferController {
    
    @Autowired
    private OfferCounterofferService offerCounterofferService;
    
    @GetMapping()
    private List<Offer> findAllOffers() {
        return offerCounterofferService.findAllOffers();
    }
    
    @GetMapping("/{objectId}")
    private Offer findOneOffer(@PathVariable String objectId) {
        return offerCounterofferService.findOneOffer(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteOffer(@PathVariable String objectId) {
        offerCounterofferService.deleteOffer(new Offer(objectId));
    }
    @PostMapping
    public Offer insertOffer(@RequestBody Offer sale) {
        return offerCounterofferService.insertOffer(sale);
    }
    @PutMapping("/{objectId}")
    public void updateOffer(@RequestBody Offer sale,@PathVariable String objectId) {
        offerCounterofferService.updateOffer(sale,objectId);
    }
    
    
}
