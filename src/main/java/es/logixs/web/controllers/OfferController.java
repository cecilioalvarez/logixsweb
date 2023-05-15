package es.logixs.web.controllers;

import es.logixs.web.domain.Offer;
import es.logixs.web.dto.OfferDTO;
import es.logixs.web.services.OfferCounterofferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("webapi/offer")
public class OfferController {
    
    @Autowired
    private OfferCounterofferService offerCounterofferService;
    
    @GetMapping()
    private List<OfferDTO> findAllOffers() {
        List<OfferDTO> listOfferDTO = new ArrayList<>();
        for (Offer offer: offerCounterofferService.findAllOffers()) {
            listOfferDTO.add(new OfferDTO(offer));
        }
        return listOfferDTO;
    }
    
    @GetMapping("/{objectId}")
    private OfferDTO findOneOffer(@PathVariable String objectId) {
        return new OfferDTO(offerCounterofferService.findOneOffer(objectId));
    }

    @DeleteMapping("/{objectId}")
    public void deleteOffer(@PathVariable String objectId) {
        offerCounterofferService.deleteOffer(objectId);
    }

    @PostMapping
    public OfferDTO insertOffer(@RequestBody OfferDTO offerDTO) {
        return new OfferDTO(offerCounterofferService.insertOffer(offerDTO.createOffer()));
    }

    @PutMapping("/{objectId}")
    public void updateOffer(@RequestBody OfferDTO offerDTO,@PathVariable String objectId){
        offerCounterofferService.updateOffer(offerDTO.createOffer(),objectId);
    }
}
