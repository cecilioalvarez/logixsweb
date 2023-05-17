/*
package es.logixs.web.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.logixs.web.domain.Product;
import es.logixs.web.services.SaleProductRequestService;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
  @Autowired
  private MockMvc mvc;
  @Autowired
  ObjectMapper objectMapper;
  @MockBean
  private SaleProductRequestService service;

  @Test
  void findAllProductsTest() throws Exception {
    Product product1 = new Product("1A", "1", "1A", "1", "scientificName1", "name1", "category1", "originCountryIso1", "quality1", "descAndSpecs1");
    Product product2 = new Product("2B", "2", "2B", "2", "scientificName2", "name2", "category2", "originCountryIso2", "quality2", "descAndSpecs2");
    Product product3 = new Product("3C", "3", "3C", "3", "scientificName3", "name3", "category3", "originCountryIso3", "quality3", "descAndSpecs3");

    List<Product> productsList = List.of(product1, product2, product3);
    when(service.findAllProducts()).thenReturn(productsList);

    String listExpected = objectMapper.writeValueAsString(productsList);

    String userListResultJSON = mvc.perform(get("/webapi/product")).andExpect(status().isOk())
            .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

    assertEquals(listExpected, userListResultJSON);

  }

  @Test
  void findOneProductTest() throws Exception {
    Product product = new Product("1A", "1", "1A", "1", "scientificName1", "name1", "category1", "originCountryIso1", "quality1", "descAndSpecs1");
    when(service.findOneProduct("1A")).thenReturn(product);

    String productExpected = objectMapper.writeValueAsString(product);
    String productResultJSON = mvc.perform(get("/webapi/product/1A")).andExpect(status().isOk())
            .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

    assertEquals(productExpected, productResultJSON);
  }

  @Test
  void deleteProductTest() throws Exception {
    Product productToDelete = new Product("1A", "1", "1A", "1", "scientificName1", "name1", "category1", "originCountryIso1", "quality1", "descAndSpecs1");
    when(service.findOneProduct("1A")).thenReturn(productToDelete);
    mvc.perform(delete("/webapi/product/1A")).andExpect(status().isOk());
    verify(service, times(1)).deleteProduct("1A");
  }

  @Test
  void insertProductTest() throws Exception {
    
    Product productToInsert = new Product("1A", "1", "1A", "1", "scientificName1", "name1", "category1", "originCountryIso1", "quality1", "descAndSpecs1");
    
    when(service.insertProduct(productToInsert)).thenReturn(productToInsert);
    
    MvcResult result = mvc.perform(post("/webapi/product")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(productToInsert))
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn();


    String responseJson = result.getResponse().getContentAsString();

    Product productCreated = objectMapper.readValue(responseJson, Product.class);

    assertEquals(productToInsert, productCreated);

    verify(service, times(1)).insertProduct(productToInsert);
  }
}
*/