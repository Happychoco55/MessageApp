package dev.terry.services;

import dev.terry.dtos.LoginCredentials;
import dev.terry.entities.AppUser;
import dev.terry.repos.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    JwtService jwtService;


    @Override
    public String authenticateUser(LoginCredentials loginCredentials) {
        AppUser user = appUserRepo.findByUsername(loginCredentials.getUsername());

        if(user == null){
            //User not found
            //throw new UserNotFoundException();
            throw new RuntimeException("User not found");
        }
        if(!user.getPassword().equals(loginCredentials.getPassword())){
            //Password incorrect
            //throw new PasswordMismatchException();
            throw new RuntimeException("Password inforrect");
        }
        return jwtService.createJwtWithUsername(user.getUsername());
    }
}
