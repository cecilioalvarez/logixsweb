package es.logixs.web.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import es.logixs.web.domain.Sale;
import es.logixs.web.repositories.mysql.SaleRepositoryMySQL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;


@SpringBootTest
@Sql({ "classpath:schemasale.sql", "classpath:datasale.sql" })
class SaleRepositoryTest {

    @Autowired
    private SaleRepositoryMySQL saleRepository;

    @Test
    void findOneTest() {
        Sale saleFinal= saleRepository.findOne("4A");

        assertEquals("4A", saleFinal.getCode());
    }

    @Test
    void findAllTest() {
        List<Sale> saleList = saleRepository.findAll();

        assertTrue(saleList.size()>=4);
    }

    @Test
    void insertTest() {
        Sale sale = new Sale("5A", "0005", "0005", "5A", "5", "5", true);

        Sale saleFinal = saleRepository.insert(sale);

        assertEquals(sale, saleFinal);
    }

    @Test
    void deleteTest() {
        Sale sale = new Sale("5A", "0005", "0005", "5A", "5", "5", false);

        saleRepository.insert(sale);
        saleRepository.delete("5A");
        List<Sale> sales = saleRepository.findAll();

        assertFalse(sales.contains(sale));

    }

    @Test
    void updateTest() {
        Sale saleToUpdate = saleRepository.findOne("1A");
        saleToUpdate.setOwnerId("0005");
        saleToUpdate.setClientId("0005");
        saleToUpdate.setCode("5A");
        saleToUpdate.setOfferId("5");
        saleToUpdate.setCounterOfferId("5");
        saleToUpdate.setCounterOffer(false);
        saleRepository.update(saleToUpdate);
        Sale saleUpdated = saleRepository.findOne("1A");

        assertEquals("0005", saleUpdated.getOwnerId());
        assertEquals("0005", saleUpdated.getClientId());
        assertEquals("5A", saleUpdated.getCode());
        assertEquals("5", saleUpdated.getOfferId());
        assertEquals("5", saleUpdated.getCounterOfferId());
        assertFalse(saleUpdated.isCounterOffer());
    }
}