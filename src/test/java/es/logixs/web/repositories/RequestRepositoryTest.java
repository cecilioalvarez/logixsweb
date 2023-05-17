package es.logixs.web.repositories;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import es.logixs.web.domain.Request;

@SpringBootTest
@Sql({ "classpath:schemarequests.sql", "classpath:datarequest.sql" })
public class RequestRepositoryTest {

    @Autowired
    private RequestRepository requestRepository;


    @Test
    void findOne() {

        Request requestFinal = requestRepository.findOne(UUID.fromString("311e8a7e-b050-44df-b86f-6718a267d014"));
        assertEquals(requestFinal.getObjectId(), UUID.fromString("311e8a7e-b050-44df-b86f-6718a267d014"));
        assertEquals(requestFinal.getCode(), "code1");
        assertFalse(requestFinal.isAccepted());
        assertEquals(requestFinal.getGlazing(), 3);
    }

    @Test
    void findAll() {
        List<Request> lista = requestRepository.findAll();
        assertTrue(lista.size()>=5);
    }

    @Test
    void insert() {
        Request request = new Request(
                UUID.randomUUID(),
                "code1",
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                false,
                UUID.randomUUID(),
                "category10",
                "scientificName10",
                "name10",
                "originalCountryIso10",
                "description10",
                "productionMethod10",
                69,
                "currency10",
                null,
                null);
        Request requestFinal = requestRepository.insert(request);
        assertEquals(request, requestFinal);
    }

    @Test
    void delete() {
        Request request = new Request(
                UUID.randomUUID(),
                "code1",
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                false,
                UUID.randomUUID(),
                "category10",
                "scientificName10",
                "name10",
                "originalCountryIso10",
                "description10",
                "productionMethod10",
                69,
                "currency10",
                null,
                null);
        requestRepository.insert(request);
        requestRepository.delete(request);
        List<Request> requestList = requestRepository.findAll();
        assertFalse(requestList.contains(request));

    }

}
