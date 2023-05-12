package es.logixs.web.services;

import es.logixs.web.domain.Product;
import es.logixs.web.domain.Request;
import es.logixs.web.domain.Sale;
import es.logixs.web.repositories.mysql.ProductRepositoryMySQL;
import es.logixs.web.repositories.mysql.RequestRepositoryMySQL;
import es.logixs.web.repositories.mysql.SaleRepositoryMySQL;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;

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
    Sale sale = new Sale("0001","0001","0001","1A","1","1",true);

    saleProductRequestService.deleteSale("1A");

    verify(saleRepositoryMock, times(1)).delete("1A");

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
    Sale sale1 = new Sale("0001","0001","0001","1A","1","1",true);
    Sale sale2 = new Sale("0002","0002","0002","2A","2","2",false);

    List<Sale> salesListMock = Arrays.asList(sale1,sale2);
    when(saleRepositoryMock.findAll()).thenReturn(salesListMock);

    List<Sale> resultSalesList = saleProductRequestService.findAllSales();

    verify(saleRepositoryMock, times(1)).findAll();
    assertEquals(salesListMock,resultSalesList);

  }

  // Products
  @Test
  public void insertProductsTest() {
    Product products = mock(Product.class);

    List<Product> productsList = List.of(products, products, products);
    List<Product> insertedproductsList = saleProductRequestService.insertProductsList(productsList);

    verify(productRepositoryMock, times(3)).insert(any(Product.class));

    assertIterableEquals(productsList, insertedproductsList);
  }

  @Test
  public void deleteProductTest() {
    Product product = new Product("7", "23", "123456789", "company1", "scientificName1", "product1", "category1", "ES", "quality1", "description1");

    saleProductRequestService.deleteProduct(product.getObjectId());

    verify(productRepositoryMock, times(1)).delete(product.getObjectId());
  }

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
    Request request = new Request("123456789", "offer6", "owner6", "company6");

    saleProductRequestService.deleteRequest(request);

    verify(requestRepositoryMock, times(1)).delete(request);
  }
}
