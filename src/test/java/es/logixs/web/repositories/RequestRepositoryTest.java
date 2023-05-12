package es.logixs.web.repositories;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
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
        requestRepository.delete(request.getObjectId());
        List<Request> requestList = requestRepository.findAll();
        assertFalse(requestList.contains(request));

    }
    
}
