package es.logixs.web.repositories;

import es.logixs.web.domain.CounterOffer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql({"classpath:schemacounteroffer.sql", "classpath:datacounteroffer.sql"})
public class CounterOfferRepositoryTest {

    @Autowired
    private CounterOfferRepository counterOfferRepository;



    @Test
    void findOne() {
        CounterOffer counterOfferFinal = counterOfferRepository.findOne("1A");

        assertEquals("name1", counterOfferFinal.getName());
    }

    @Test
    void findAll() {
        List<CounterOffer> counterOfferList = counterOfferRepository.findAll();

        assertTrue(counterOfferList.size() >= 4);
    }

    @Test
    void insert() {
        CounterOffer counterOffer = new CounterOffer("5A", "name5", "vom5", 2.0, 4.0, 10.0);

        CounterOffer counterOfferFinal = counterOfferRepository.insert(counterOffer);

        assertEquals(counterOffer, counterOfferFinal);
    }

    @Test
    void delete() {
        CounterOffer counterOffer = new CounterOffer("6A", "name6", "vom6", 2.0, 4.0, 10.0);

        counterOfferRepository.insert(counterOffer);
        counterOfferRepository.delete(counterOffer);
        List<CounterOffer> counterOffers = counterOfferRepository.findAll();

        assertFalse(counterOffers.contains(counterOffer));

    }

    @Test
    void update() {
        CounterOffer counterOfferToUpdate = counterOfferRepository.findOne("1A");
        counterOfferToUpdate.setCounterOfferPrice(10);
        counterOfferToUpdate.setName("nombre 1 actualizado");

        counterOfferRepository.update(counterOfferToUpdate);
        CounterOffer counterOfferUpdated = counterOfferRepository.findOne("1A");

        assertEquals(counterOfferToUpdate.getName(), counterOfferUpdated.getName());
        assertEquals(counterOfferToUpdate.getCounterOfferPrice(), counterOfferUpdated.getCounterOfferPrice());
    }
}