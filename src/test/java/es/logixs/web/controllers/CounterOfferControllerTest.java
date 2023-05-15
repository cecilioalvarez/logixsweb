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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CounterOfferControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private OfferCounterofferService offerCounterofferService;

    @Test
    void findAllCounterOffers() throws Exception {
        CounterOffer counterOffer1 = new CounterOffer("1A", "name1", "vom1", 2.0, 4.0, 10.0);
        CounterOffer counterOffer2 = new CounterOffer("2A", "name2", "vom2", 2.0, 4.0, 10.0);
        CounterOffer counterOffer3 = new CounterOffer("3A", "name3", "vom3", 2.0, 4.0, 10.0);
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
        CounterOffer counterOffer = new CounterOffer("1A", "name1", "vom1", 2.0, 4.0, 10.0);

        when(offerCounterofferService.findOneCounterOffer("1A")).thenReturn(counterOffer);
        String counterOfferJsonResult = mvc.perform(get("/webapi/counteroffer/1A"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        String counterOfferExpected = objectMapper.writeValueAsString(counterOffer);

        assertEquals(counterOfferExpected, counterOfferJsonResult);
    }

    @Test
    void deleteCounterOffer() throws Exception {
        CounterOffer counterOffer = new CounterOffer("1A", "name1", "vom1", 2.0, 4.0, 10.0);

        when(offerCounterofferService.findOneCounterOffer("1A")).thenReturn(counterOffer);
        mvc.perform(delete("/webapi/counteroffer/1A")).andExpect(status().isOk());

        verify(offerCounterofferService, times(1)).deleteCounterOffer(counterOffer);
    }

    @Test
    void insertCounterOffer() throws Exception {
        CounterOffer counterOffer = new CounterOffer("1A", "name1", "vom1", 2.0, 4.0, 10.0);

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
        CounterOffer counterOfferToUpdate = new CounterOffer("1A", "name1", "vom1", 2, 3, 10);
        counterOfferToUpdate.setCounterOfferPrice(10);
        counterOfferToUpdate.setName("nombre 1 actualizado");

        when(offerCounterofferService.findOneCounterOffer("1A")).thenReturn(counterOfferToUpdate);
        offerCounterofferService.updateCounterOffer(counterOfferToUpdate, "1A");
        mvc.perform(put("/webapi/counteroffer/1A")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(counterOfferToUpdate))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        CounterOffer counterOfferUpdated = offerCounterofferService.findOneCounterOffer("1A");

        assertEquals(counterOfferToUpdate.getName(), counterOfferUpdated.getName());
        assertEquals(counterOfferToUpdate.getCounterOfferPrice(), counterOfferUpdated.getCounterOfferPrice());
    }
}
