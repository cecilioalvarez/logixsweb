package es.logixs.web.controllers;

import es.logixs.web.domain.Offer;
import es.logixs.web.dto.OfferDTO;
import es.logixs.web.services.OfferCounterofferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("webapi/offer")
public class OfferController {

    @Autowired
    private OfferCounterofferService offerCounterofferService;

    @GetMapping()
    private List<OfferDTO> findAllOffers() {
        List<OfferDTO> listOfferDTO = new ArrayList<>();
        for (Offer offer : offerCounterofferService.findAllOffers()) {
            listOfferDTO.add(new OfferDTO(offer));
        }
        return listOfferDTO;
    }

    @GetMapping("/{objectId}")
    private OfferDTO findOneOffer(@PathVariable String objectId) {
        return new OfferDTO(offerCounterofferService.findOneOffer(UUID.fromString(objectId)));
    }

    @DeleteMapping("/{objectId}")
    public void deleteOffer(@PathVariable String objectId) {
        offerCounterofferService.deleteOffer(UUID.fromString(objectId));
    }

    @PostMapping
    public OfferDTO insertOffer(@RequestBody OfferDTO offerDTO) {
        return new OfferDTO(offerCounterofferService.insertOffer(offerDTO.createOffer()));
    }

    @PutMapping("/{objectId}")
    public void updateOffer(@RequestBody OfferDTO offerDTO,
                            @PathVariable String objectId) {
        offerCounterofferService.updateOffer(offerDTO.createOffer(), UUID.fromString(objectId));
    }
}
