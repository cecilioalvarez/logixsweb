
package es.logixs.web.repositories;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import es.logixs.web.domain.User;
import es.logixs.web.repositories.mysql.UserRepositoryMySQL;


import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql({"classpath:schemausers.sql", "classpath:datausers.sql"})
@Tag("usercompany")
class UserRepositoryTest {

    @Autowired
    private UserRepositoryMySQL userRepositoryMySQL;

    @Test
    void insertTest() throws ParseException {
        User user = new User(
                UUID.randomUUID(),
                "Ana",
                "Sanchez",
                "ana@mail.com",
                "state",
                "avatar",
                "password",
                "prevPassword",
                "companyId",
                "invitedBy",
                "role",
                10.0,
                "address",
                "phone",
                "city",
                "zipCode",
                "countryIso",
                null,
                null
        );

        User userFinal = userRepositoryMySQL.insert(user);

        assertEquals(user, userFinal);
    }
    @Test
    void insertTestDuplicatePK() throws ParseException {
        User user = new User(
                UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"),
                "Ana",
                "Sanchez",
                "ana@mail.com",
                "state",
                "avatar",
                "password",
                "prevPassword",
                "companyId",
                "invitedBy",
                "role",
                10.0,
                "address",
                "phone",
                "city",
                "zipCode",
                "countryIso",
                null,
                null
        );

        User userFinal = userRepositoryMySQL.insert(user);

        assertEquals(user, userFinal);
    }

    @Test
    void deleteTest() {
        User user = new User(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"));

        userRepositoryMySQL.delete(user);
        List<User> allUsers = userRepositoryMySQL.findAll();

        assertFalse(allUsers.contains(user));

    }

    @Test
    void findOneTest() {
        User user = userRepositoryMySQL.findOne(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"));


        assertEquals("Pedro", user.getName());
        assertEquals("Sanchez", user.getLastName());
        assertEquals("pedro@mail.com", user.getEmail());
    }

    @Test
    void findAllTest() {
        List<User> lista = userRepositoryMySQL.findAll();

        assertTrue(lista.size() >= 4);
    }

    @Test
    void updateFieldsTest() {
        User userToUpdate = userRepositoryMySQL.findOne(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"));

        userToUpdate.setEmail("pepe100@gmail.com");
        userToUpdate.setName("marta");
        userToUpdate.setLastName("gomez");
        userRepositoryMySQL.update(userToUpdate);
        User userUpdated = userRepositoryMySQL.findOne(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"));

        assertEquals(userToUpdate.getEmail(), userUpdated.getEmail());
        assertEquals(userToUpdate.getName(), userUpdated.getName());
        assertEquals(userToUpdate.getLastName(), userUpdated.getLastName());
    }

    @Test
    void updateFieldsIDTest() {
        User userToUpdate = userRepositoryMySQL.findOne(UUID.fromString("391e8a7e-b050-44df-b86f-6718a267d014"));

        userToUpdate.setObjectId(UUID.fromString("491e8a7e-b050-44df-b86f-6718a267d014"));
        userToUpdate.setEmail("pepe100@gmail.com");
        userToUpdate.setName("marta");
        userToUpdate.setLastName("gomez");
        userRepositoryMySQL.update(userToUpdate);
        User userUpdated = userRepositoryMySQL.findOne(UUID.fromString("491e8a7e-b050-44df-b86f-6718a267d014"));

        assertEquals(userToUpdate.getEmail(), userUpdated.getEmail());
        assertEquals(userToUpdate.getName(), userUpdated.getName());
        assertEquals(userToUpdate.getLastName(), userUpdated.getLastName());
    }
}

