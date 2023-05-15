package es.logixs.web.controllers;

import es.logixs.web.domain.CounterOffer;
import es.logixs.web.domain.User;
import es.logixs.web.dto.CounterOfferDTO;
import es.logixs.web.dto.UserDTO;
import es.logixs.web.services.OfferCounterofferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("webapi/counteroffer")
public class CounterOfferController {
    @Autowired
    private OfferCounterofferService offerCounterofferService;

    @GetMapping
    public List<CounterOfferDTO> findAllCounterOffers() {
        List<CounterOfferDTO> counterOfferDTOList = new ArrayList<>();
        for (CounterOffer counterOffer : offerCounterofferService.findAllCounterOffers()) {
            counterOfferDTOList.add(new CounterOfferDTO(counterOffer));
        }
        return counterOfferDTOList;
    }

    @GetMapping("/{objectId}")
    public CounterOfferDTO findOneCounterOffer(@PathVariable String objectId) {
        return new CounterOfferDTO(offerCounterofferService.findOneCounterOffer(objectId));
    }

    @DeleteMapping("/{objectId}")
    public void deleteCounterOffer(@PathVariable String objectId) {
        offerCounterofferService.deleteCounterOffer(new CounterOffer(objectId));
    }

    @PostMapping
    public CounterOffer insertCounterOffer(@RequestBody CounterOfferDTO counterOfferDto) {
        return offerCounterofferService.insertCounterOffer(counterOfferDto.createCounterOffer());
    }

    @PutMapping("/{objectId}")
    public void updateCounterOffer(@RequestBody CounterOfferDTO counterOfferDto, @PathVariable String objectId) {
        offerCounterofferService.updateCounterOffer(counterOfferDto.createCounterOffer(), objectId);
    }

}
