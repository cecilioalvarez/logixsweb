package es.logixs.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.logixs.web.domain.CounterOffer;
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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CounterOfferControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private OfferCounterofferService offerCounterofferService;

    @Test
    void findAllCounterOffers() throws Exception {
        CounterOffer counterOffer1 = new CounterOffer(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"), "name1", "vom1", 2.0, 4.0, 10.0);
        CounterOffer counterOffer2 = new CounterOffer(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d015"), "name2", "vom2", 2.0, 4.0, 10.0);
        CounterOffer counterOffer3 = new CounterOffer(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d016"), "name3", "vom3", 2.0, 4.0, 10.0);
        List<CounterOffer> counterOfferList = List.of(counterOffer1, counterOffer2, counterOffer3);

        when(offerCounterofferService.findAllCounterOffers()).thenReturn(counterOfferList);
        String counterOfferListResultJSON = mvc.perform(get("/webapi/counteroffer"))
                .andExpect(status().isOk())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        String listExpected = objectMapper.writeValueAsString(counterOfferList);

        assertEquals(listExpected, counterOfferListResultJSON);
    }

    @Test
    void findOneCounterOffer() throws Exception {
        CounterOffer counterOffer = new CounterOffer(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"), "name1", "vom1", 2.0, 4.0, 10.0);

        when(offerCounterofferService.findOneCounterOffer(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"))).thenReturn(counterOffer);
        String counterOfferJsonResult = mvc.perform(get("/webapi/counteroffer/391e8a7e-b050-44df-b86f-6718a267d014"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        String counterOfferExpected = objectMapper.writeValueAsString(counterOffer);

        assertEquals(counterOfferExpected, counterOfferJsonResult);
    }

    @Test
    void deleteCounterOffer() throws Exception {
        UUID objectId = UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014");
        CounterOffer counterOffer = new CounterOffer(objectId, "name1", "vom1", 2.0, 4.0, 10.0);

        when(offerCounterofferService.findOneCounterOffer(objectId)).thenReturn(counterOffer);
        mvc.perform(delete("/webapi/counteroffer/391e8a7e-b050-44df-b86f-6718a267d014")).andExpect(status().isOk());

        verify(offerCounterofferService, times(1)).deleteCounterOffer(objectId);
    }

    @Test
    void insertCounterOffer() throws Exception {
        CounterOffer counterOffer = new CounterOffer(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"), "name1", "vom1", 2.0, 4.0, 10.0);

        when(offerCounterofferService.insertCounterOffer(counterOffer)).thenReturn(counterOffer);
        MvcResult result = mvc.perform(post("/webapi/counteroffer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(counterOffer))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String responseJson = result.getResponse().getContentAsString();
        CounterOffer createdCounterOffer = objectMapper.readValue(responseJson, CounterOffer.class);

        assertEquals(counterOffer, createdCounterOffer);
        verify(offerCounterofferService, times(1)).insertCounterOffer(counterOffer);
    }

    @Test
    void updateCounterOffer() throws Exception {
        CounterOffer counterOfferToUpdate = new CounterOffer(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"), "name1", "vom1", 2, 3, 10);
        counterOfferToUpdate.setCounterOfferPrice(10);
        counterOfferToUpdate.setName("nombre 1 actualizado");

        when(offerCounterofferService.findOneCounterOffer(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"))).thenReturn(counterOfferToUpdate);
        offerCounterofferService.updateCounterOffer(counterOfferToUpdate, UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"));
        mvc.perform(put("/webapi/counteroffer/391e8a7e-b050-44df-b86f-6718a267d014")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(counterOfferToUpdate))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        CounterOffer counterOfferUpdated = offerCounterofferService.findOneCounterOffer(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"));

        assertEquals(counterOfferToUpdate.getName(), counterOfferUpdated.getName());
        assertEquals(counterOfferToUpdate.getCounterOfferPrice(), counterOfferUpdated.getCounterOfferPrice());
    }
}
