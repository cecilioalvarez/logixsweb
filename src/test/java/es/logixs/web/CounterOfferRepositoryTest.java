package es.logixs.web;

import es.logixs.web.repositories.CounterOfferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;

@SpringBootTest
@Sql({ "classpath:schemacounteroffer.sql", "classpath:datacounteroffer.sql" })
class CounterOfferRepositoryTest {

    @Autowired
    private CounterOfferRepository counterOfferRepository;



    @BeforeEach
    public void inicializar() throws IOException {


    }


}