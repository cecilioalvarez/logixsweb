package es.logixs.web.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import es.logixs.web.domain.Product;
import es.logixs.web.domain.Request;
import es.logixs.web.domain.Sale;
import es.logixs.web.repositories.mysql.ProductRepositoryMySQL;
import es.logixs.web.repositories.mysql.RequestRepositoryMySQL;
import es.logixs.web.repositories.mysql.SaleRepositoryMySQL;

@SpringBootTest
public class SaleProductRequestServiceTest {

  @MockBean
  private SaleRepositoryMySQL saleRepositoryMock;
  @MockBean
  private ProductRepositoryMySQL productRepositoryMock;
  @MockBean
  private RequestRepositoryMySQL requestRepositoryMock;
  @Autowired
  private SaleProductRequestService saleProductRequestService;
  @Test
  public void deleteSaleTest() {
    Sale sale = new Sale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"),"0001","0001","1A","1","1",true);

    saleProductRequestService.deleteSale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"));

    verify(saleRepositoryMock, times(1)).delete(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"));

  }


  @Test
  public void insertSaleTest() {
    Sale sales = mock(Sale.class);

    List<Sale> salesList = List.of(sales, sales, sales);
    List<Sale> insertedSaleList = saleProductRequestService.insertSalesList(salesList);

    verify(saleRepositoryMock, times(3)).insert(any(Sale.class));

    assertIterableEquals(salesList, insertedSaleList);
  }



  @Test
  public void findAllSalesTest() {
    Sale sale1 = new Sale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"),"0001","0001","1A","1","1",true);
    Sale sale2 = new Sale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d021"), "0002", "0002", "2A", "2", "2", true);

    List<Sale> salesListMock = Arrays.asList(sale1,sale2);
    when(saleRepositoryMock.findAll()).thenReturn(salesListMock);

    List<Sale> resultSalesList = saleProductRequestService.findAllSales();

    verify(saleRepositoryMock, times(1)).findAll();
    assertEquals(salesListMock,resultSalesList);

  }

  // Products
  /*
  @Test
  public void insertProductsTest() {
    Product products = mock(Product.class);

    List<Product> productsList = List.of(products, products, products);
    List<Product> insertedproductsList = saleProductRequestService.insertProductsList(productsList);

    verify(productRepositoryMock, times(3)).insert(any(Product.class));

    assertIterableEquals(productsList, insertedproductsList);
  }
*//*
  @Test
  public void deleteProductTest() {
    Product product = new Product("7", "23", "123456789", "company1", "scientificName1", "product1", "category1", "ES", "quality1", "description1");

    saleProductRequestService.deleteProduct(product.getObjectId());

    verify(productRepositoryMock, times(1)).delete(product.getObjectId());
  }
*/
  // Request
  @Test
  public void insertRequestTest() {
    Request request = mock(Request.class);

    List<Request> requestsList = List.of(request, request, request);
    List<Request> insertedRequestList = saleProductRequestService.insertRequestsList(requestsList);

    verify(requestRepositoryMock, times(3)).insert(any(Request.class));

    assertIterableEquals(requestsList, insertedRequestList);
  }

  @Test
  public void deleteRequestTest() {
    //Request request = new Request("123456789", "offer6", "owner6", "company6");Request request = mock(Request.class);
      Request request = mock(Request.class);
      when(request.getObjectId()).thenReturn(UUID.fromString("311e8a7e-b050-44df-b86f-6718a267d014"));
    saleProductRequestService.deleteRequest(request);

    verify(requestRepositoryMock, times(1)).delete(request);
  }
}


