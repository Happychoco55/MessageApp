package dev.terry.services;

import dev.terry.entities.AppUser;
import dev.terry.repos.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    AppUserRepo appUserRepo;

    @Override
    public AppUser createUser(AppUser appUser) {

        //User input error handling goes here.

        //Create the user, return the user
        return this.appUserRepo.save(appUser);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return this.appUserRepo.findAll();
    }

    @Override
    public AppUser getUserWithUsername(String username) {
        AppUser appUser = this.appUserRepo.findByUsername(username);
        appUser.setPassword("");
        return appUser;
    }

    @Override
    public AppUser getUserWithId(int id) {
        return this.appUserRepo.findById(id);
    }


}
