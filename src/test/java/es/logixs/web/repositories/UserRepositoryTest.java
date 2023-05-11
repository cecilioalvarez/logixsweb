package es.logixs.web.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import es.logixs.web.domain.User;
import es.logixs.web.repositories.mysql.UserRepositoryMySQL;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql({ "classpath:schemausers.sql", "classpath:datausers.sql" })
class UserRepositoryTest {

    @Autowired
    private UserRepositoryMySQL repository;

    @Test
    void insert() {
        User user = new User("5A", "Ana", "Sanchez", "ana@mail.com");
        User userFinal = repository.insert(user);
        assertEquals(user, userFinal);
    }

    @Test
    void delete() {
        User user = new User("5A", "Ana", "Sanchez", "ana@mail.com");
        repository.delete(user);
        List<User> allUsers = repository.findAll();
         assertFalse(allUsers.contains(user));

    }

    @Test
    void findOne() {
        User user = repository.findOne("2A");
        assertEquals("2A", user.getObjectid());
        assertEquals("Pedro", user.getName());
        assertEquals("Sanchez", user.getLastName());
        assertEquals("pedro@mail.com", user.getEmail());
    }

    @Test
    void findAll() {
        List<User> lista = repository.findAll();
        assertTrue(lista.size() >= 4);
    }
}
