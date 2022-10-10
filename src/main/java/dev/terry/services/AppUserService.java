package dev.terry.services;

import dev.terry.entities.AppUser;

import java.util.List;

public interface AppUserService {

    AppUser createUser(AppUser appUser);

    List<AppUser> getAllUsers();

    AppUser getUserWithUsername(String username);
}
