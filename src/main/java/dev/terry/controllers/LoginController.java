package dev.terry.controllers;

import dev.terry.dtos.LoginCredentials;
import dev.terry.services.JwtService;
import dev.terry.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody LoginCredentials loginCredentials){
        return loginService.authenticateUser(loginCredentials);
    }

}
