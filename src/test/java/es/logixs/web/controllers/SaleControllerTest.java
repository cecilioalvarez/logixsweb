package es.logixs.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.logixs.web.domain.Sale;
import es.logixs.web.services.SaleProductRequestService;
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
public class SaleControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private SaleProductRequestService service;

    @Test
    void findAllSalesTest() throws Exception {
        Sale sale1 = new Sale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"),"0001","0001","1A","1","1",true);
        Sale sale2 = new Sale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d021"), "0002", "0002", "2A", "2", "2", true);
        Sale sale3 = new Sale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d022"), "0003", "0003", "3A", "2", "2", false);

        List<Sale> saleList = List.of(sale1, sale2, sale3);
        when(service.findAllSales()).thenReturn(saleList);

        String listExpected = objectMapper.writeValueAsString(saleList);
        // test de risa
        String saleListResultJSON = mvc.perform(get("/webapi/sale")).andExpect(status().isOk())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(listExpected, saleListResultJSON);
    }

    @Test
    void findOneSaleTest() throws Exception {
        Sale sale = new Sale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"),"0001","0001","1A","1","1",true);

        when(service.findOneSale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"))).thenReturn(sale);

        String saleExpected = objectMapper.writeValueAsString(sale);

        String saleResultJSON = mvc.perform(get("/webapi/sale/391e8a7e-b050-44df-b86f-6718a267d020")).andExpect(status().isOk())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(saleExpected, saleResultJSON);
    }

    @Test
    void deleteSaleTest() throws Exception {
        Sale saleToDelete = new Sale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"),"0001","0001","1A","1","1",true);

        when(service.findOneSale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"))).thenReturn(saleToDelete);

        mvc.perform(delete("/webapi/sale/391e8a7e-b050-44df-b86f-6718a267d020"))
                .andExpect(status().isOk());

        verify(service, times(1)).deleteSale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"));
    }

    @Test
    void insertSaleTest() throws Exception {
        Sale sale = new Sale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"),"0001","0001","1A","1","1",true);

        when(service.insertSale(sale)).thenReturn(sale);
        MvcResult result = mvc.perform(post("/webapi/sale")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sale))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        String responseJSON = result.getResponse().getContentAsString();
        Sale createdSale = objectMapper.readValue(responseJSON, Sale.class);
        assertEquals(sale, createdSale);

        verify(service, times(1)).insertSale(sale);
    }

    @Test
    void updateSale() throws Exception {
        Sale saleToUpdate = new Sale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"),"0001","0001","1A","1","1",true);
        saleToUpdate.setCode("bbb");
        saleToUpdate.setClientId("1A");

        when(service.findOneSale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"))).thenReturn(saleToUpdate);
        service.updateSale(saleToUpdate, UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"));
        mvc.perform(put("/webapi/sale/391e8a7e-b050-44df-b86f-6718a267d020")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saleToUpdate))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Sale saleUpdated = service.findOneSale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"));

        assertEquals(saleToUpdate.getCode(), saleUpdated.getCode());
        assertEquals(saleToUpdate.getClientId(), saleUpdated.getClientId());
    }

}


