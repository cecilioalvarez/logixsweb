package es.logixs.web.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import es.logixs.web.domain.CounterOffer;
import es.logixs.web.domain.Offer;
import es.logixs.web.repositories.mysql.CounterOfferRepositoryMySQL;
import es.logixs.web.repositories.mysql.OfferRepositoryMySQL;

@SpringBootTest
public class OfferCounterofferServiceTest {
    @MockBean
    public OfferRepositoryMySQL offerRepositoryMock;
    @MockBean
    public CounterOfferRepositoryMySQL counterOfferRepositoryMock;
    @Autowired
    public OfferCounterofferService offersService;

    @Test
    public void findAllCounterOfferTest() {
        CounterOffer counterOffer1 = mock(CounterOffer.class);
        CounterOffer counterOffer2 = mock(CounterOffer.class);
        List<CounterOffer> listCounterOffer = Arrays.asList(counterOffer1, counterOffer2);

        when(counterOfferRepositoryMock.findAll()).thenReturn(listCounterOffer);

        List<CounterOffer> listCounterOfferResult = offersService.findAllCounterOffers();
        verify(counterOfferRepositoryMock, times(1)).findAll();
        assertEquals(listCounterOffer, listCounterOfferResult);
    }
    @Test
    public void findAllOffersTest() {
        Offer offer1 = mock(Offer.class);
        Offer offer2 = mock(Offer.class);

        List<Offer> listOffer = Arrays.asList(offer1, offer2);

        when(offerRepositoryMock.findAll()).thenReturn(listOffer);

        List<Offer> listOfferResult = offersService.findAllOffers();
        verify(offerRepositoryMock, times(1)).findAll();
        assertEquals(listOffer, listOfferResult);
    }

    @Test
    public void insertCounterOfferTest() {
        CounterOffer counterOffer = mock(CounterOffer.class);
        when(counterOfferRepositoryMock.insert(counterOffer)).thenReturn(counterOffer);

        CounterOffer insertedCounterOffer = offersService.insertCounterOffer(counterOffer);
        verify(counterOfferRepositoryMock, times(1)).insert(counterOffer);
        assertEquals(counterOffer, insertedCounterOffer);
    }

    @Test
    public void insertOfferTest() {
        Offer offer = mock(Offer.class);
        when(offerRepositoryMock.insert(offer)).thenReturn(offer);

        Offer insertedOffer = offersService.insertOffer(offer);

        verify(offerRepositoryMock, times(1)).insert(offer);
        assertEquals(offer, insertedOffer);
    }

    @Test
    public void deleteOfferTest() {
        offersService.deleteOffer("A2");
        verify(offerRepositoryMock, times(1)).delete("A2");
    }

    @Test
    public void deleteCounterOffer() {
        CounterOffer counterOffers = mock(CounterOffer.class);
        offersService.deleteCounterOffer(counterOffers);
        verify(counterOfferRepositoryMock, times(1)).delete(counterOffers);
    }

    @Test
    public void findOneCounterOffer() {
        String objectId = "A2";

        CounterOffer counterOffer = mock(CounterOffer.class);

        when(counterOfferRepositoryMock.findOne(objectId)).thenReturn(counterOffer);
        CounterOffer counterOfferResult = offersService.findOneCounterOffer(objectId);

        verify(counterOfferRepositoryMock, times(1)).findOne(objectId);
        assertEquals(counterOffer, counterOfferResult);
    }

    @Test
    public void findOneOffer() {
        String objectId = "A2";

        Offer offer = mock(Offer.class);

        when(offerRepositoryMock.findOne(objectId)).thenReturn(offer);
        Offer offerResult = offersService.findOneOffer(objectId);

        verify(offerRepositoryMock, times(1)).findOne(objectId);
        assertEquals(offer, offerResult);
    }
}
