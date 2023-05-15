package es.logixs.web.repositories;

import org.junit.jupiter.api.Tag;
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
@Tag("usercompany")
class UserRepositoryTest {

    @Autowired
    private UserRepositoryMySQL repository;

    @Test
    void insertTest() {
        User user = new User("5A", "Ana", "Sanchez", "ana@mail.com");
        User userFinal = repository.insert(user);
        assertEquals(user, userFinal);
    }

    @Test
    void deleteTest() {
        User user = new User("5A", "Ana", "Sanchez", "ana@mail.com");
        repository.delete(user);
        List<User> allUsers = repository.findAll();
        assertFalse(allUsers.contains(user));

    }

    @Test
    void findOneTest() {
        User user = repository.findOne("2A");
        assertEquals("2A", user.getObjectId());
        assertEquals("Pedro", user.getName());
        assertEquals("Sanchez", user.getLastName());
        assertEquals("pedro@mail.com", user.getEmail());
    }

    @Test
    void findAllTest() {
        List<User> lista = repository.findAll();
        assertTrue(lista.size() >= 4);
    }

    @Test
    void updateFieldsTest() {

        User userToUpdate = repository.findOne("2A");

        userToUpdate.setEmail("pepe100@gmail.com");
        userToUpdate.setName("marta");
        userToUpdate.setLastName("gomez");

        repository.update(userToUpdate);
        User userUpdated = repository.findOne("2A");

        assertEquals(userToUpdate.getEmail(), userUpdated.getEmail());
        assertEquals(userToUpdate.getName(), userUpdated.getName());
        assertEquals(userToUpdate.getLastName(), userUpdated.getLastName());
    }

    @Test
    void updateFieldsTesWithObjectId() {

        User actualUser = repository.findOne("2A");
        User newDataForUser = new User();
        newDataForUser.setObjectId("5J");
        newDataForUser.setEmail("pepe100@gmail.com");
        newDataForUser.setName("marta");
        newDataForUser.setLastName("gomez");

        repository.update(newDataForUser, actualUser);
        User userFullUpdated = repository.findOne("5J");

        assertEquals(userFullUpdated.getEmail(), newDataForUser.getEmail());
        assertEquals(userFullUpdated.getEmail(), newDataForUser.getEmail());
        assertEquals(userFullUpdated.getName(), newDataForUser.getName());
        assertEquals(userFullUpdated.getLastName(), newDataForUser.getLastName());
    }
}
