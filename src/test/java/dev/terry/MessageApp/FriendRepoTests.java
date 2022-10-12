package dev.terry.MessageApp;

import dev.terry.entities.Friend;
import dev.terry.repos.FriendRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class FriendRepoTests {
    @Autowired
    FriendRepo friendRepo;

    @Test
    void check_if_already_exists(){
        List<Friend> friendList = friendRepo.checkIfAlreadyExists(3, 10);
        Assertions.assertNotEquals(0, friendList.size());
    }

    @Test
    void decline_friend(){
        int i = friendRepo.declineFriend(3, 10, "Pending");
        System.out.println(i);
    }

    @Test
    void accept_friend(){
        int i = friendRepo.acceptFriend(3, 10);
        System.out.println(i);
    }

}
