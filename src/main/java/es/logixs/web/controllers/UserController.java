package es.logixs.web.controllers;

import es.logixs.web.domain.User;
import es.logixs.web.dto.UserDTO;
import es.logixs.web.services.UserCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("webapi/user")
public class UserController {

    @Autowired
    private UserCompanyService servicioUserCompany;

    @GetMapping
    public List<UserDTO> findAllUsers() {

        List<UserDTO> listUserDto= new ArrayList<UserDTO>();
        
        for (User user: servicioUserCompany.findAllUsers() ) {

                listUserDto.add(new UserDTO(user));
        }

        return listUserDto;
    }

    @GetMapping("/{objectId}")
    public UserDTO findOneUser(@PathVariable String objectId) {


        return new UserDTO(servicioUserCompany.findOneUser(objectId));
    }

    @DeleteMapping("/{objectId}")
    public void deleteUser(@PathVariable String objectId) {

        servicioUserCompany.deleteUser(new User(objectId));
    }
    @PostMapping
    public User insertUser(@RequestBody UserDTO userDto) {
        return servicioUserCompany.insertUser(userDto.getUser());
    }
    @PutMapping("/{objectId}")
    public void updateUser(@RequestBody UserDTO userDto,@PathVariable String objectId) {
        servicioUserCompany.updateUser(userDto.getUser(),objectId);
    }

  
   

}
