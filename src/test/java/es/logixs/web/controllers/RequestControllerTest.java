/*
package es.logixs.web.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;


import es.logixs.web.domain.Request;
import es.logixs.web.services.SaleProductRequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.test.web.servlet.MvcResult;
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
    void findAllRequestsTest() throws Exception {
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

    @Test
    void findOneRequestTest() throws Exception {
        Request request = new Request("9A", "10A", "11A", "12A", "13A");
        when(service.findOneRequest("9A")).thenReturn(request);
        String requestJsonResult = mvc.perform(get("/webapi/request/9A")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        String requestExpected = objectMapper.writeValueAsString(request);

        assertEquals(requestExpected,requestJsonResult);
    }

    @Test
    void deleteRequestTest() throws Exception {

        Request request = new Request("1A", "1AC", "4321A", "PWC","1234A");

        when(service.insertRequest(request)).thenReturn(request);

        mvc.perform(delete("/webapi/request/1A")).andExpect(status().isOk());

        verify(service, times(1)).deleteRequest("1A");
    }

    @Test
    void insertRequestTest() throws  Exception {
        Request request = new Request("1A", "1AC", "4321A", "PWC","1234A");

        when(service.insertRequest(request)).thenReturn(request);
        MvcResult result = mvc.perform(post("/webapi/request")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content( objectMapper.writeValueAsString(request))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        String responseJson = result.getResponse().getContentAsString();
        System.out.println(responseJson);

        Request createdRequest = objectMapper.readValue(responseJson, Request.class);
        assertEquals(request, createdRequest);

        verify(service, times(1)).insertRequest(request);

    }
}

 */
