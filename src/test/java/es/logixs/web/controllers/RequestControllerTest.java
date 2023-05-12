package es.logixs.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.logixs.web.domain.Request;
import es.logixs.web.services.SaleProductRequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RequestControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private SaleProductRequestService service;

    @Test
    void findAllRequest() throws Exception {
        Request request1 = new Request("4B","5B","6B","7B", "8B");
        Request request2 = new Request("4B","5B","6B","7B", "8B");
        Request request3 = new Request("4B","5B","6B","7B", "8B");

        List<Request> requestList = List.of(request1,request2,request3);
        when(service.findAllRequests()).thenReturn(requestList);

        String listExpected = objectMapper.writeValueAsString(requestList);

        String requestListResultJSON = mvc.perform(get("/webapi/request")).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertEquals(listExpected, requestListResultJSON);
    }
}
