package es.logixs.web;

import es.logixs.web.domain.Sale;
import es.logixs.web.repositories.SaleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql({ "classpath:schemasale.sql", "classpath:datasale.sql" })
class SaleRepositoryTest {

    @Autowired
    private SaleRepository saleRepository;



    @BeforeEach
    public void inicializar() throws IOException {


    }

    @Test
    void findOne() {
        Sale saleFinal= saleRepository.findOne("4A");

        assertEquals("4A", saleFinal.getCode());
    }

    @Test
    void findAll() {
        List<Sale> saleList = saleRepository.findAll();

        assertTrue(saleList.size()>=4);
    }

    @Test
    void insert() {
        Sale sale = new Sale("5A", "0005", "0005", "5A", "5", "5", true);

        Sale saleFinal = saleRepository.insert(sale);

        assertEquals(sale, saleFinal);
    }


}