package es.logixs.web.controllers;

import es.logixs.web.domain.User;
import es.logixs.web.services.UsersCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webapi/user")
public class UserController {

    @Autowired
    private UsersCompanyService servicioUserCompany;

    @GetMapping
    public List<User> findAllUsers() {
        return servicioUserCompany.findAllUsers();
    }

    @GetMapping("/{objectId}")
    public User findOneUser(@PathVariable String objectId) {
        return servicioUserCompany.findOneUser(objectId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteUser(@PathVariable String objectId) {

        servicioUserCompany.deleteUser(new User(objectId));
    }
    @PostMapping
    public User insertUser(@RequestBody User user) {
        return servicioUserCompany.insertUser(user);
    }
    @PutMapping("/{objectId}")
    public void updateUser(@RequestBody User user,@PathVariable String objectId) {
        servicioUserCompany.updateUser(user,objectId);
    }

  
   

}
