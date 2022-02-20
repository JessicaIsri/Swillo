package br.gov.sp.fatec.swillo.controllers;

import br.gov.sp.fatec.swillo.models.User;
import br.gov.sp.fatec.swillo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("user/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
