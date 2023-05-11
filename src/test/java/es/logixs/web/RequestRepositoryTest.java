package es.logixs.web;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import es.logixs.web.domain.Request;
import es.logixs.web.repositories.RequestRepository;

@SpringBootTest
@Sql({ "classpath:schemarequests.sql", "classpath:datarequest.sql" })
public class RequestRepositoryTest {

    @Autowired
    private RequestRepository requestRepository;



    @BeforeEach
    public void inicializar() throws IOException {


    }
    @Test
    void findOne() {
        Request requestFinal;
        requestFinal = requestRepository.findOne("1A");
        assertEquals("1A", requestFinal.getObjectId());
    }

    @Test
    void findAll() {
        List<Request> lista = requestRepository.findAll();
        assertTrue(lista.size()>=5);
    }
    @Test
    void insert() {
        Request request = new Request("6A", "7a", "7b", "7c", "7c");
        Request requestFinal = requestRepository.insert(request);
        assertEquals(request, requestFinal);
    }

    @Test
    void delete() {
        Request request = new Request("6A","7a", "7b", "7c", "7c");
        requestRepository.insert(request);
        requestRepository.delete(request);
        List<Request> requestList = requestRepository.findAll();
        assertFalse(requestList.contains(request));

    }
    
}
