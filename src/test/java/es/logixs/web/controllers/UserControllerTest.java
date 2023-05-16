package es.logixs.web.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.DateFormat;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.logixs.web.domain.User;
import es.logixs.web.services.UserCompanyService;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private UserCompanyService service;

    @Test
    void findAllUsersTest() throws Exception {
        User user1 = new User("1A", "pedro", "perez", "pedro@gmail.com", "state", "avatar",
                "password", "prevPassword", "companyId", "invitedBy", "role", 10.0,
                "address", "phone", "city", "zipCode", "countryIso",
                null, null
        );
        User user2 = new User("2B", "ana", "gomez", "ana@gmail.com", "state", "avatar",
                "password", "prevPassword", "companyId", "invitedBy", "role", 10.0,
                "address", "phone", "city", "zipCode", "countryIso",
                null, null
        );
        User user3 = new User("3C", "gema", "sanchez", "gema@gmail.com", "state", "avatar",
                "password", "prevPassword", "companyId", "invitedBy", "role", 10.0,
                "address", "phone", "city", "zipCode", "countryIso",
                null, null
        );

        List<User> userList = List.of(user1, user2, user3);
        when(service.findAllUsers()).thenReturn(userList);

        String listExpected = objectMapper.writeValueAsString(userList);
        String userListResultJSON = mvc.perform(get("/webapi/user")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(listExpected, userListResultJSON);
    }

    @Test
    void findOneUserTest() throws Exception {

        User user1 = new User("1A", "pedro", "perez", "pedro@gmail.com", "state", "avatar",
                "password", "prevPassword", "companyId", "invitedBy", "role", 10.0,
                "address", "phone", "city", "zipCode", "countryIso",
                null, null
        );

        when(service.findOneUser("1A")).thenReturn(user1);

        String userJsonResult = mvc.perform(get("/webapi/user/1A")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();

        String userExpected = objectMapper.writeValueAsString(user1);

        assertEquals(userExpected, userJsonResult);
    }

    @Test
    void deleteUserTest() throws Exception {

        User userToDelete = new User(
                "1A", "pedro", "perez", "pedro@gmail.com", "state", "avatar",
                "password", "prevPassword", "companyId", "invitedBy", "role", 10.0,
                "address", "phone", "city", "zipCode", "countryIso",
                null, null
        );

        when(service.findOneUser("1A")).thenReturn(userToDelete);

        mvc.perform(delete("/webapi/user/1A"))
                .andExpect(status().isOk());

        verify(service, times(1)).deleteUser(userToDelete);

    }

    @Test
    void insertUserTest() throws Exception {
        User user1 = new User(
                "6A", "pedro", "perez", "pedro@gmail.com", "state", "avatar",
                "password", "prevPassword", "companyId", "invitedBy", "role", 10.0,
                "address", "phone", "city", "zipCode", "countryIso",
                null, null
        );

        when(service.insertUser(user1)).thenReturn(user1);
        MvcResult result = mvc.perform(post("/webapi/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user1))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        String responseJson = result.getResponse().getContentAsString();
        User createdUser = objectMapper.readValue(responseJson, User.class);
        assertEquals(user1, createdUser);

        verify(service, times(1)).insertUser(user1);

    }
}
