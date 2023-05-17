package es.logixs.web.controllers;

import es.logixs.web.domain.User;
import es.logixs.web.dto.UserDTO;
import es.logixs.web.services.UserCompanyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {
    @Mock
    private UserCompanyService userCompanyService;
    @InjectMocks
    private AuthController authController;

    @Test
    @DisplayName("Should throw an exception when registering an admin with invalid input")
    void registerAdminWithInvalidInputThrowsException() {
        UserDTO userDTO = new UserDTO();

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            authController.registerAdmin(userDTO);
        });

        verify(userCompanyService, never()).insertUser(any(User.class));
    }

    @Test
    @DisplayName("Should register a new admin successfully")
    void registerAdminSuccessfully() {
        UserDTO userDTO = new UserDTO("1", "John", "Doe", "john.doe@example.com",
                "state", "avatar", "password", "prevPassword", "companyId",
                "invitedBy", "role", 10.0, "address", "phone", "city",
                "zipCode", "countryIso", null, null
        );
        User user = new User("1", "John", "Doe", "john.doe@example.com",
                "state", "avatar", "password", "prevPassword", "companyId",
                "invitedBy", "role", 10.0, "address", "phone", "city",
                "zipCode", "countryIso", null, null
        );

        when(userCompanyService.insertUser(any(User.class))).thenReturn(user);
        UserDTO result = authController.registerAdmin(userDTO);

        assertNotNull(result);
        assertEquals(userDTO.getName(), result.getName());
        assertEquals(userDTO.getLastName(), result.getLastName());
        assertEquals(userDTO.getEmail(), result.getEmail());
        verify(userCompanyService, times(1)).insertUser(any(User.class));
    }
}