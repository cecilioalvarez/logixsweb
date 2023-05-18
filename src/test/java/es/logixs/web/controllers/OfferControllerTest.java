package es.logixs.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.logixs.web.domain.Offer;
import es.logixs.web.dto.OfferDTO;
import es.logixs.web.services.OfferCounterofferService;
import org.junit.jupiter.api.DisplayName;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OfferControllerTest {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mvc;
    @MockBean
    private OfferCounterofferService service;


    @Test
    @DisplayName("Should update the offer with the given objectId and new offer details")
    void
    updateOfferWithGivenObjectIdAndNewOfferDetails() { // create an OfferDTO object with
        // updated details
        UUID objectId = UUID.fromString("df5dd66d-43fd-477f-ac5d-02b0347d2091");
        OfferDTO updatedOfferDTO =
                new OfferDTO(
                        objectId,
                        "CODE123",
                        "Updated Offer",
                        "This is an updated offer",
                        "Updated Category");

        // create a mock Offer object with the same objectId as the updatedOfferDTO
        Offer mockOffer = new Offer(objectId, "CODE123", "Offer", "This is an offer", "Category");

        // mock the service method to return the mockOffer when called with the objectId
        when(service.findOneOffer(objectId)).thenReturn(mockOffer);

        // perform the PUT request with the updatedOfferDTO as the request body
        try {
            MvcResult result =
                    mvc.perform(
                                    put("/webapi/offer/1234")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(
                                                    objectMapper.writeValueAsString(
                                                            updatedOfferDTO)))
                            .andExpect(status().isOk())
                            .andReturn();

            // verify that the service method was called with the updated Offer object and the
            // objectId
            verify(service, times(1)).updateOffer(any(Offer.class), eq(objectId));

            // verify that the response body is the updatedOfferDTO
            String responseBody = result.getResponse().getContentAsString();
            OfferDTO responseOfferDTO = objectMapper.readValue(responseBody, OfferDTO.class);
            assertEquals(updatedOfferDTO, responseOfferDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void findAllOffersTest() throws Exception {

        Offer offer1 = new Offer(UUID.fromString("df5dd66d-43fd-477f-ac5d-02b0347d2091"), "code1", "name1", "description1", "category1");
        Offer offer2 = new Offer(UUID.fromString("df5dd66d-43fd-477f-ac5d-02b0347d2092"), "code2", "name2", "description2",
                "category2");
        Offer offer3 = new Offer(UUID.fromString("df5dd66d-43fd-477f-ac5d-02b0347d2093"), "code3", "name3", "description3", "category4");

        List<Offer> offerList = List.of(offer1, offer2, offer3);
        when(service.findAllOffers()).thenReturn(offerList);

        String listExpected = objectMapper.writeValueAsString(offerList);
        String offerListResultJSON = mvc.perform(get("/webapi/offer")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(listExpected, offerListResultJSON);
    }

    @Test
    void findOneOfferTest() throws Exception {

        UUID objectId = UUID.fromString("df5dd66d-43fd-477f-ac5d-02b0347d2091");
        Offer offer1 = new Offer(objectId, "code1", "name1", "description1",
                "category1");

        when(service.findOneOffer(objectId)).thenReturn(offer1);

        String offerJsonResult = mvc.perform(get("/webapi/offer/df5dd66d-43fd-477f-ac5d-02b0347d2091")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();

        String offerExpected = objectMapper.writeValueAsString(offer1);

        assertEquals(offerExpected, offerJsonResult);
    }

    @Test
    void insertOfferTest() throws Exception {

        UUID objectId = UUID.fromString("df5dd66d-43fd-477f-ac5d-02b0347d2091");
        Offer offer1 = new Offer(objectId, "code1", "name1", "description1",
                "category1");

        when(service.insertOffer(offer1)).thenReturn(offer1);
        MvcResult result = mvc.perform(post("/webapi/offer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(offer1))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        String responseJson = result.getResponse().getContentAsString();
        Offer createdOffer = objectMapper.readValue(responseJson, Offer.class);
        assertEquals(offer1, createdOffer);

        verify(service, times(1)).insertOffer(offer1);

    }

    @Test
    void deleteOfferTest() throws Exception {

        UUID objectId = UUID.fromString("df5dd66d-43fd-477f-ac5d-02b0347d2091");
        Offer offerToDelete = new Offer(objectId, "code1", "name1", "description1",
                "category1");

        when(service.findOneOffer(objectId)).thenReturn(offerToDelete);

        mvc.perform(delete("/webapi/offer/df5dd66d-43fd-477f-ac5d-02b0347d2091"))
                .andExpect(status().isOk());

        verify(service, times(1)).deleteOffer(objectId);

    }
}
