package es.logixs.web.repositories;

import es.logixs.web.domain.Offer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@Sql({"classpath:schemaoffers.sql", "classpath:dataoffers.sql"})
public
class OfferRepositoryTest {

    @Autowired
    private OfferRepository offerRepository;

    @Test
    void insert() {
        Offer offer = new Offer(UUID.randomUUID(), "123456789", "offer1", "description offer 1", "category1");
        Offer offerFinal = offerRepository.insert(offer);
        assertEquals(offer, offerFinal);
    }

    //
    @Test
    void delete() {
        Offer offer = new Offer(UUID.fromString("df5dd66d-43fd-477f-ac5d-02b0347d2091"));
        offerRepository.delete(offer.getObjectId());
        List<Offer> allOffers = offerRepository.findAll();
        assertFalse(allOffers.contains(offer));
    }

    @Test
    void update() {
        Offer offerOld = offerRepository.findOne(UUID.fromString("df5dd66d-43fd-477f-ac5d-02b0347d2091"));
        offerOld.setDescription("new description");
        offerOld.setCategory("new category");
        offerOld.setCode("new code");
        offerOld.setName("new name");
        offerRepository.update(offerOld);
        Offer offerFinal = offerRepository.findOne(UUID.fromString("df5dd66d-43fd-477f-ac5d-02b0347d2091"));
        assertEquals(offerOld.getCode(), offerFinal.getCode());
        assertEquals(offerOld.getName(), offerFinal.getName());
        assertEquals(offerOld.getDescription(), offerFinal.getDescription());
        assertEquals(offerOld.getCategory(), offerFinal.getCategory());
    }

    @Test
    void findOne() {
        Offer offer = offerRepository.findOne(UUID.fromString("df5dd66d-43fd-477f-ac5d-02b0347d2091"));
        assertEquals(UUID.fromString("df5dd66d-43fd-477f-ac5d-02b0347d2091"), offer.getObjectId());
        assertEquals("code1", offer.getCode());
        assertEquals("name1", offer.getName());
        assertEquals("description1", offer.getDescription());
        assertEquals("category1", offer.getCategory());
    }

    @Test
    void findAll() {
        List<Offer> allOffers = offerRepository.findAll();
        assertFalse(allOffers.isEmpty());
    }
}
