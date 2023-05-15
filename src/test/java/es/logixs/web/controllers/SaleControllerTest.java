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
        Sale sale1 = new Sale("1A", "1B", "1B", "aaa", "aaa", "aaa", false);
        Sale sale2 = new Sale("2A", "2B", "2B", "bbb", "bbb", "bbb", false);
        Sale sale3 = new Sale("3A", "3B", "3B", "ccc", "ccc", "ccc", false);

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
        Sale sale1 = new Sale("1A", "1B", "1B", "aaa", "aaa", "aaa", false);

        when(service.findOneSale("1A")).thenReturn(sale1);

        String saleExpected = objectMapper.writeValueAsString(sale1);
        // test de risa
        String saleResultJSON = mvc.perform(get("/webapi/sale/1A")).andExpect(status().isOk())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(saleExpected, saleResultJSON);
    }

    @Test
    void deleteSaleTest() throws Exception {
        Sale saleToDelete = new Sale("1A", "1B", "1B", "aaa", "aaa", "aaa", false);

        when(service.findOneSale("1A")).thenReturn(saleToDelete);

        mvc.perform(delete("/webapi/sale/1A"))
                .andExpect(status().isOk());

        verify(service, times(1)).deleteSale("1A");
    }

    @Test
    void insertSaleTest() throws Exception {
        Sale sale = new Sale("1A", "1B", "1B", "aaa", "aaa", "aaa", false);

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
        Sale saleToUpdate = new Sale("1A", "1B", "1B", "aaa", "aaa", "aaa", false);
        saleToUpdate.setCode("bbb");
        saleToUpdate.setClientId("1A");

        when(service.findOneSale("1A")).thenReturn(saleToUpdate);
        service.updateSale(saleToUpdate, "1A");
        mvc.perform(put("/webapi/sale/1A")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saleToUpdate))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Sale saleUpdated = service.findOneSale("1A");

        assertEquals(saleToUpdate.getCode(), saleUpdated.getCode());
        assertEquals(saleToUpdate.getClientId(), saleUpdated.getClientId());
    }
}
