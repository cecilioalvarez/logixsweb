package es.logixs.web.repositories;

import es.logixs.web.domain.Product;
import es.logixs.web.repositories.mysql.ProductRepositoryMySQL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql({"classpath:schemaproduct.sql", "classpath:dataproduct.sql"})
public class ProductRepositoryTest {

  @Autowired
  private ProductRepositoryMySQL productRepository;

  @Test
  void findOne() {
    Product productFinal = productRepository.findOne(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"));
    assertEquals("name1", productFinal.getName());
  }

  @Test
  void findAll() {
    List<Product> products = productRepository.findAll();
    assertTrue(products.size() >= 3);
  }

  @Test
  void insert() {
    Product product =
        new Product(
            UUID.randomUUID(),
            "4",
            "4",
            "4D",
            "scientificName4",
            "name4",
            "category4",
            "ES",
            "quality4",
            "descAndSpecs4",
            0.0,
            "productionMethod4",
            "packing4",
            "description4",
            new Date(),
            new Date());
    Product productFinal = productRepository.insert(product);
    assertEquals(product, productFinal);
  }

  @Test
  void delete() {
    Product product =
        new Product(
            UUID.fromString("550e8400-e29b-41d4-a716-446655440000"),
            "4",
            "4",
            "4D",
            "scientificName4",
            "name4",
            "category4",
            "ES",
            "quality4",
            "descAndSpecs4",
            0.0,
            "productionMethod4",
            "packing4",
            "description4",
            new Date(),
            new Date());
    productRepository.delete(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"));
    List<Product> products = productRepository.findAll();
    assertFalse(products.contains(product));
  }
}
