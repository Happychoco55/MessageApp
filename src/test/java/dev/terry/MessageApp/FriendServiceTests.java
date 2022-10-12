package dev.terry.MessageApp;

import dev.terry.entities.Friend;
import dev.terry.services.FriendService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class FriendServiceTests {

//    @Autowired
//    FriendService friendListService;
//
//    @Test
//    void find_by_status() {
//        List<Friend> friendList = this.friendListService.findPendingRequests(10, "Pending");
////        System.out.println(friendList.toString());
//        Assertions.assertEquals(0, friendList.size());
//    }
//
//    @Test
//    void add_friend() {
//        int i = this.friendListService.addFriend(3, 10);
//        System.out.println(i);
//        List<Friend> friendList = this.friendListService.findPendingRequests(10, "Pending");
//        Assertions.assertNotEquals(0, friendList.size());
//    }
//
//
//    @Test
//    void check_if_already_exists() {
//        Assertions.assertFalse(this.friendListService.checkIfAlreadyExists(3, 10));
//    }
//

}
