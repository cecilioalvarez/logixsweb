package es.logixs.web;

import es.logixs.web.domain.Offer;
import es.logixs.web.repositories.OfferRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql({ "classpath:schemaoffers.sql", "classpath:dataoffers.sql" })
class OfferRepositoryTest {

    @Autowired
    private OfferRepository offerRepository;

    @Test
    void insert() {
        Offer offer = new Offer("A1", "123456789", "offer1", "description offer 1", "category1");
        Offer offerFinal = offerRepository.insert(offer);
        assertEquals(offer, offerFinal);
    }

    @Test
    void delete() {
        Offer offer = new Offer("A1", "123456789", "offer1", "description offer 1", "category1");
        offerRepository.insert(offer);
        offerRepository.delete(offer);
        List<Offer> lista = offerRepository.findAll();
        assertFalse(lista.contains(offer));
    }

    @Test
    void findOne() {
        Offer offer = offerRepository.findOne("A2");
        assertEquals("A2", offer.getObjectId());
    }

    @Test
    void findAll() {
        List<Offer> lista = offerRepository.findAll();
        assertTrue(lista.size()>=5);
    }
}
