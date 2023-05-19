package es.logixs.web.controllers;

import es.logixs.web.domain.User;
import es.logixs.web.dto.UserDTO;
import es.logixs.web.services.UserCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("webapi/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserController {
    @Autowired
    private UserCompanyService userCompanyService;

    @GetMapping

    public List<UserDTO> findAllUsers() {
        List<UserDTO> listUserDto = new ArrayList<UserDTO>();
        for (User user : userCompanyService.findAllUsers()) {
            listUserDto.add(new UserDTO(user));
        }
        return listUserDto;
    }

    @GetMapping("/{objectId}")
    public UserDTO findOneUser(@PathVariable String objectId) {
        return new UserDTO(userCompanyService.findOneUser(UUID.fromString(objectId)));
    }

    @DeleteMapping("/{objectId}")
    public void deleteUser(@PathVariable String objectId) {
        userCompanyService.deleteUser(new User(UUID.fromString(objectId)));
    }

    @PostMapping
    public User insertUser(@RequestBody UserDTO userDto) {
        return userCompanyService.insertUser(userDto.crearUsuario());
    }

    @PutMapping("/{objectId}")
    public void updateUser(@RequestBody UserDTO userDto, @PathVariable String objectId) {
        userCompanyService.updateUser(userDto.crearUsuario(), UUID.fromString(objectId));
    }

}
