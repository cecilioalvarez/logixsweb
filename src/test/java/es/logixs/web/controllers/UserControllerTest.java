package es.logixs.web.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.logixs.web.domain.User;
import es.logixs.web.services.UserCompanyService;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    // que hace peticiones http a traves de los objectos mock
    @Autowired
    private MockMvc mvc;
    @Autowired ObjectMapper objectMapper;
    @MockBean
    private UserCompanyService servicio;

    @Test
    void findAllUsersTest() throws Exception {

        User user1 = new User("1A", "pedro", "perez", "pedro@gmail.com");
        User user2 = new User("2B", "ana", "gomez", "ana@gmail.com");
        User user3 = new User("3C", "gema", "sanchez", "gema@gmail.com");

        List<User> userList=List.of(user1, user2, user3);
        when(servicio.findAllUsers()).thenReturn(userList);

        String listExpected= objectMapper.writeValueAsString(userList);
        // test de risa
        String userListResultJSON=mvc.perform(get("/webapi/user")).andExpect(status().isOk()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(listExpected,userListResultJSON);
    }

    @Test
    void findOneUserTest() throws Exception {

        User user1 = new User("1A", "pedro", "perez", "pedro@gmail.com");
    

        when(servicio.findOneUser("1A")).thenReturn(user1);
        // test de risa
        String userJsonResult=mvc.perform(get("/webapi/user/1A")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        String userExpected= objectMapper.writeValueAsString(user1);

        assertEquals(userExpected,userJsonResult);
    }

    @Test
    void findOneUser2Test() throws Exception {

        User user1 = new User("1A", "pedro", "perez", "pedro@gmail.com");
    

        when(servicio.findOneUser("1A")).thenReturn(user1);
        // test de risa
        String userJsonResult=mvc.perform(get("/webapi/user/1A")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        String userExpected= "{\"objectId\":\"1A\",\"name\":\"pedro\",\"lastName\":\"perez\",\"email\":\"pedro@gmail.com\"}";

        assertEquals(userExpected,userJsonResult);
    }



}
