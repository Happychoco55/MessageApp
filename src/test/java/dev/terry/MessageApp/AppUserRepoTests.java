package dev.terry.MessageApp;

import dev.terry.entities.AppUser;
import dev.terry.repos.AppUserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class AppUserRepoTests {

    @Autowired
    AppUserRepo appUserRepo;

    @Test
    void create_user(){
        AppUser appUser = new AppUser(0, "Burger", "Man", "BurgerMan234", "1","I am a burger man");
        AppUser savedAppUser = this.appUserRepo.save(appUser);
        Assertions.assertNotEquals(0, savedAppUser.getId());
    }

    @Test
    void get_all_users(){
        List<AppUser> appUserList = new ArrayList<>();
        AppUser appUser = new AppUser(0, "Burger", "Man", "BurgerMan234", "1","I am a burger man");
        AppUser appUser1 = new AppUser(0, "Burger", "Man", "BurgerMan234", "1","I am a burger man");
        AppUser savedAppUser = this.appUserRepo.save(appUser);
        AppUser savedAppUser1 = this.appUserRepo.save(appUser);
        appUserList = this.appUserRepo.findAll();

        Assertions.assertNotEquals(0, appUserRepo.findAll());
    }

    @Test
    void find_by_username(){
        AppUser appUserList = this.appUserRepo.findByUsername("Happy");
        System.out.println(appUserList.toString());
        Assertions.assertNotEquals(0, appUserList.getId());
    }

}
