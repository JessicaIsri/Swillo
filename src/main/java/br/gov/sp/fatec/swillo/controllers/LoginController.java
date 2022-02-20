package br.gov.sp.fatec.swillo.controllers;

import br.gov.sp.fatec.swillo.models.User;
import br.gov.sp.fatec.swillo.models.dtos.UserDTO;
import br.gov.sp.fatec.swillo.services.UserService;
import br.gov.sp.fatec.swillo.utils.JwtUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping(path = "api/login")
    public UserDTO login(@RequestBody UserDTO login)
            throws JsonProcessingException {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(login.getName(), login.getPassword());
        Authentication auth = authenticationManager.authenticate(authenticationToken);
        User user = userService.getUserByName(auth.getName());
        login.setPassword(null);
        login.setId(user.getId());
        login.setToken(JwtUtils.generateToken(auth));
        login.setAutorizacao(auth.getAuthorities().iterator().next().getAuthority());
        return login;
    }
}
