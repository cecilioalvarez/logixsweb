package es.logixs.web;

import es.logixs.web.domain.Product;
import es.logixs.web.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
  @Sql({"classpath:schemaproduct.sql", "classpath:dataproduct.sql"})
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findOne() {
        Product productFinal = productRepository.findOne("1");
        assertEquals("name1", productFinal.getName());
    }

    @Test
    void findAll() {
      List<Product> products = productRepository.findAll();
      assertTrue(products.size()>=3);
    }

    @Test
    void insert(){
      Product product = new Product("4", "4A", "4", "scientificName4", "name4", "category4", "ES", "quality4", "descAndSpecs4");
      Product productfinal = productRepository.insert(product);
      assertEquals(product, productfinal);
    }

    @Test
    void delete(){
      Product product = new Product("5", "5A", "5", "scientificName5", "name5", "category5", "ES", "quality5", "descAndSpecs5");
      productRepository.insert(product);
      productRepository.delete("5");
      List<Product> products = productRepository.findAll();
      assertFalse(products.contains(product));
    }
}
