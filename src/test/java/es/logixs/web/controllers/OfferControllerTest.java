package es.logixs.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.logixs.web.domain.Offer;
import es.logixs.web.services.OfferCounterofferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OfferControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private OfferCounterofferService service;

    @Test
    void findAllOffersTest() throws Exception {

        Offer offer1 = new Offer("A2","code1","name1","description1","category1");
        Offer offer2 = new Offer("B2","code2","name2","description2","category2");
        Offer offer3 = new Offer("C3","code3","name3","description3","category4");

        List<Offer> offerList = List.of(offer1, offer2, offer3);
        when(service.findAllOffers()).thenReturn(offerList);

        String listExpected = objectMapper.writeValueAsString(offerList);
        String offerListResultJSON = mvc.perform(get("/webapi/offer")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(listExpected, offerListResultJSON);
    }

    @Test
    void findOneOfferTest() throws Exception {

        Offer offer1 = new Offer("A2","code1","name1","description1","category1");

        when(service.findOneOffer("A2")).thenReturn(offer1);

        String offerJsonResult = mvc.perform(get("/webapi/offer/A2")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();

        String offerExpected = objectMapper.writeValueAsString(offer1);

        assertEquals(offerExpected, offerJsonResult);
    }

    @Test
    void insertOfferTest() throws Exception {

        Offer offer1 = new Offer("A2","code1","name1","description1","category1");

        when(service.insertOffer(offer1)).thenReturn(offer1);
        MvcResult result = mvc.perform(post("/webapi/offer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content( objectMapper.writeValueAsString(offer1))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        String responseJson = result.getResponse().getContentAsString();
        Offer createdOffer = objectMapper.readValue(responseJson, Offer.class);
        assertEquals(offer1, createdOffer);

        verify(service, times(1)).insertOffer(offer1);

    }

    @Test
    void deleteOfferTest() throws Exception {

        Offer offerToDelete = new Offer("A2","code1","name1","description1","category1");

        when(service.findOneOffer("A2")).thenReturn(offerToDelete);

        mvc.perform(delete("/webapi/offer/A2"))
                .andExpect(status().isOk());

        verify(service, times(1)).deleteOffer("A2");

    }
}
