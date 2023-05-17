package es.logixs.web.controllers;

import es.logixs.web.dto.UserDTO;
import es.logixs.web.services.UserCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("webapi/auth")
public class AuthController {

    @Autowired
    private UserCompanyService userCompanyService;


    @PostMapping("admin/register")
    public UserDTO registerAdmin(@RequestBody UserDTO userDTO) {
        try {
            // userDTO.setRole("ROLE_ADMIN");
            // JWT for authentication (only for admin)
            if (userDTO == null ||
                    userDTO.getName() == null ||
                    userDTO.getEmail() == null ||
                    userDTO.getLastName() == null) {
                throw new IllegalArgumentException("Invalid arguments");
            }
            return new UserDTO(userCompanyService.insertUser(userDTO.crearUsuario()));
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
