package es.logixs.web.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.logixs.web.domain.User;
import es.logixs.web.services.UserCompanyService;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    // que hace peticiones http a traves de los objectos mock
    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private UserCompanyService service;

    @Test
    void findAllUsersTest() throws Exception {

        User user1 = new User("1A", "pedro", "perez", "pedro@gmail.com");
        User user2 = new User("2B", "ana", "gomez", "ana@gmail.com");
        User user3 = new User("3C", "gema", "sanchez", "gema@gmail.com");

        List<User> userList = List.of(user1, user2, user3);
        when(service.findAllUsers()).thenReturn(userList);

        String listExpected = objectMapper.writeValueAsString(userList);
        // test de risa
        String userListResultJSON = mvc.perform(get("/webapi/user")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(listExpected, userListResultJSON);
    }

    @Test
    void findOneUserTest() throws Exception {

        User user1 = new User("1A", "pedro", "perez", "pedro@gmail.com");

        when(service.findOneUser("1A")).thenReturn(user1);
        // test de risa
        String userJsonResult = mvc.perform(get("/webapi/user/1A")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();

        String userExpected = objectMapper.writeValueAsString(user1);

        assertEquals(userExpected, userJsonResult);
    }

    @Test
    void deleteUserTest() throws Exception {

        User userToDelete = new User("1A", "Pedro", "Perez", "pedro@gmail.com");

        when(service.findOneUser("1A")).thenReturn(userToDelete);

        mvc.perform(delete("/webapi/user/1A"))
                .andExpect(status().isOk());

        verify(service, times(1)).deleteUser(userToDelete);

    }

    @Test
    void insertUserTest() throws Exception {

        User user1 = new User("10A","juan","gomez","juan@gmail.com");

        // verify(servicio,times(1)).deleteUser(user1);
        // test de risa

        when(service.insertUser(user1)).thenReturn(user1);
        MvcResult result = mvc.perform(post("/webapi/user")
        .contentType(MediaType.APPLICATION_JSON)
        .content( objectMapper.writeValueAsString(user1))
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn();

        String responseJson = result.getResponse().getContentAsString();
        User createdUser = objectMapper.readValue(responseJson, User.class);
        assertEquals(user1, createdUser);

        // Verifica que el servicio haya sido llamado con el usuario correcto
        verify(service, times(1)).insertUser(user1);

    }
}
