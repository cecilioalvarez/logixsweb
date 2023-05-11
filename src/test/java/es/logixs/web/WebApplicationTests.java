package es.logixs.web;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({ "classpath:schemausers.sql", "classpath:datausers.sql" })

class WebApplicationTests {

	@Test
	void contextLoads() {

		assertTrue(true);
	}

}
