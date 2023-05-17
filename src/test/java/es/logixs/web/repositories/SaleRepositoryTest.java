package es.logixs.web.repositories;

import es.logixs.web.domain.Sale;
import es.logixs.web.repositories.mysql.SaleRepositoryMySQL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Sql({"classpath:schemasale.sql", "classpath:datasale.sql"})
class SaleRepositoryTest {

  @Autowired
  private SaleRepositoryMySQL saleRepositoryMySQL;

  @Test
  void findOneTest() {
    Sale saleFinal = saleRepositoryMySQL.findOne(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"));

    assertEquals("1A", saleFinal.getCode());
  }

  @Test
  void findAllTest() {
    List<Sale> saleList = saleRepositoryMySQL.findAll();

    assertTrue(saleList.size() >= 4);
  }

  @Test
  void insertTest() {
    Sale sale = new Sale(UUID.randomUUID(), "0005", "0005", "5A", "5", "5", true);

    Sale saleFinal = saleRepositoryMySQL.insert(sale);

    assertEquals(sale, saleFinal);
  }

  @Test
  void deleteTest() {
    Sale sale = new Sale(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"));

    saleRepositoryMySQL.delete(sale.getObjectId());
    List<Sale> sales = saleRepositoryMySQL.findAll();

    assertFalse(sales.contains(sale));

  }

  @Test
  void updateTest() {
    Sale saleToUpdate = saleRepositoryMySQL.findOne(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"));
    saleToUpdate.setOwnerId("0005");
    saleToUpdate.setClientId("0005");
    saleToUpdate.setCode("5A");
    saleToUpdate.setOfferId("5");
    saleToUpdate.setCounterOfferId("5");
    saleToUpdate.setCounterOffer(false);
    saleRepositoryMySQL.update(saleToUpdate);
    Sale saleUpdated = saleRepositoryMySQL.findOne(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"));

    assertEquals("0005", saleUpdated.getOwnerId());
    assertEquals("0005", saleUpdated.getClientId());
    assertEquals("5A", saleUpdated.getCode());
    assertEquals("5", saleUpdated.getOfferId());
    assertEquals("5", saleUpdated.getCounterOfferId());
    assertFalse(saleUpdated.isCounterOffer());
  }

    @Test
    void updateFieldsIDTest() {
        Sale saleToUpdate = saleRepositoryMySQL.findOne(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"));
        saleToUpdate.setObjectId(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"));
        saleToUpdate.setOwnerId("0005");
        saleToUpdate.setClientId("0005");
        saleToUpdate.setCode("5A");
        saleToUpdate.setOfferId("5");
        saleToUpdate.setCounterOfferId("5");
        saleToUpdate.setCounterOffer(false);
        saleRepositoryMySQL.update(saleToUpdate);
        Sale saleUpdated = saleRepositoryMySQL.findOne(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d020"));

        assertEquals("0005", saleUpdated.getOwnerId());
        assertEquals("0005", saleUpdated.getClientId());
        assertEquals("5A", saleUpdated.getCode());
        assertEquals("5", saleUpdated.getOfferId());
        assertEquals("5", saleUpdated.getCounterOfferId());
        assertFalse(saleUpdated.isCounterOffer());
    }
}