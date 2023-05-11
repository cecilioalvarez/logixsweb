package es.logixs.web;

import es.logixs.web.domain.CounterOffer;
import es.logixs.web.repositories.CounterOfferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql({ "classpath:schemacounteroffer.sql", "classpath:datacounteroffer.sql" })
class CounterOfferRepositoryTest {

    @Autowired
    private CounterOfferRepository counterOfferRepository;



    @BeforeEach
    public void inicializar() throws IOException {


    }

    @Test
    void findOne() {
        CounterOffer counterOfferFinal= counterOfferRepository.findOne("1A");

        assertEquals("name1", counterOfferFinal.getName());
    }

    @Test
    void findAll() {
        List<CounterOffer> counterOfferList = counterOfferRepository.findAll();

        assertTrue(counterOfferList.size()>=4);
    }


}