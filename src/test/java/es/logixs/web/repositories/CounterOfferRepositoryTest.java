package es.logixs.web.repositories;

import es.logixs.web.domain.CounterOffer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql({"classpath:schemacounteroffer.sql", "classpath:datacounteroffer.sql"})
public class CounterOfferRepositoryTest {

    @Autowired
    private CounterOfferRepository counterOfferRepository;

    @Test
    void findOne() {
        CounterOffer counterOfferFinal = counterOfferRepository.findOne(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"));

        assertEquals("name1", counterOfferFinal.getName());
    }

    @Test
    void findAll() {
        List<CounterOffer> counterOfferList = counterOfferRepository.findAll();

        assertTrue(counterOfferList.size() >= 4);
    }

    @Test
    void insert() {
        CounterOffer counterOffer = new CounterOffer(UUID.randomUUID(), "name5", "vom5", 2.0, 4.0, 10.0);

        CounterOffer counterOfferFinal = counterOfferRepository.insert(counterOffer);

        assertEquals(counterOffer, counterOfferFinal);
    }

    @Test
    void delete() {
        CounterOffer counterOffer = new CounterOffer(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"));

        counterOfferRepository.delete(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"));
        List<CounterOffer> counterOffers = counterOfferRepository.findAll();

        assertFalse(counterOffers.contains(counterOffer));
    }

    @Test
    void update() {
        CounterOffer counterOfferToUpdate = counterOfferRepository.findOne(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"));

        counterOfferToUpdate.setCounterOfferPrice(10);
        counterOfferToUpdate.setName("nombre 1 actualizado");
        counterOfferRepository.update(counterOfferToUpdate);
        CounterOffer counterOfferUpdated = counterOfferRepository.findOne(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"));

        assertEquals(counterOfferToUpdate.getName(), counterOfferUpdated.getName());
        assertEquals(counterOfferToUpdate.getCounterOfferPrice(), counterOfferUpdated.getCounterOfferPrice());
    }
}