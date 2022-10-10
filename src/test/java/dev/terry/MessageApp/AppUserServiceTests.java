package dev.terry.MessageApp;

import dev.terry.entities.AppUser;
import dev.terry.services.AppUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class AppUserServiceTests {

    @Autowired
    AppUserService appUserService;

    @Test
    void find_by_username(){
        List<AppUser> appUserList = this.appUserService.getUsersWithUsername("Happychoco5");
        System.out.println(appUserList.toString());
        Assertions.assertNotEquals(0, appUserList.size());
    }

}
