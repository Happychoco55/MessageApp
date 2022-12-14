package dev.terry.controllers;

import dev.terry.entities.AppUser;
import dev.terry.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @PostMapping("/appusers")
    public AppUser createUser(@RequestBody AppUser appUser){
        return this.appUserService.createUser(appUser);
    }

    @GetMapping("/appusers")
    public List<AppUser> getAllUsers(){
        return this.appUserService.getAllUsers();
    }

    @GetMapping("/appusers/{username}")
    public AppUser getUserWithUsername(@PathVariable String username){
        return this.appUserService.getUserWithUsername(username);
    }

    @GetMapping("/appusers/id/{id}")
    public AppUser getUserWithId(@PathVariable String id){
        return this.appUserService.getUserWithId(Integer.parseInt(id));
    }

}
