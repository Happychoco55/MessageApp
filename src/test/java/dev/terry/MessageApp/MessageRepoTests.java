package dev.terry.MessageApp;

import dev.terry.entities.AppUser;
import dev.terry.entities.Message;
import dev.terry.repos.AppUserRepo;
import dev.terry.repos.MessageRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class MessageRepoTests {

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    MessageRepo messageRepo;

    @Test
    void send_message(){
        AppUser appUser = new AppUser(0, "Burger", "Man", "BurgerMan234", "1","I am a burger man");
        AppUser appUser1 = new AppUser(0, "Burger", "Man", "BurgerMan234", "1","I am a burger man");

        AppUser savedAppUser = this.appUserRepo.save(appUser);
        AppUser savedAppUser1 = this.appUserRepo.save(appUser1);

        Message message = new Message(0, savedAppUser.getId(), savedAppUser1.getId(), 0, "Hello there.");
        Message savedMessage = this.messageRepo.save(message);

        Assertions.assertNotEquals(0, savedMessage.getMessageId());
    }

    @Test
    void get_messages_between_users(){
        AppUser appUser = new AppUser(0, "Burger", "Man", "BurgerMan234", "1","I am a burger man");
        AppUser appUser1 = new AppUser(0, "Burger", "Child", "BurgerChild234", "1","I am a burger child");

        AppUser savedAppUser = this.appUserRepo.save(appUser);
        AppUser savedAppUser1 = this.appUserRepo.save(appUser1);

        Message message = new Message(0, savedAppUser.getId(), savedAppUser1.getId(), 0, "Hello there.");
        Message message1 = new Message(0, savedAppUser1.getId(), savedAppUser.getId(), 0, "Hi");

        List<Message> messageList = this.messageRepo.getMessagesBetweenUsers(savedAppUser.getId(), savedAppUser1.getId());
        System.out.println(messageList.toString());

        Assertions.assertEquals(2, messageList.size());

    }

}
