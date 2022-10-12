package dev.terry.controllers;

import dev.terry.entities.Friend;
import dev.terry.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FriendController {

    @Autowired
    FriendService friendService;

    @PostMapping("/friends")
    int addFriend(@RequestBody Friend friend){
        System.out.println("Called! " + friend.toString());
        int success = this.friendService.addFriend(friend.getUserid(), friend.getFriend_id());
        if(success <= 0){
            //Unsuccessful
            return success;
        }
        else{
            //Successful
            return success;
        }
    }

    @GetMapping("/friends/pending/{id}")
    List<Friend> findPendingRequests(@PathVariable String id){
        int myId = Integer.parseInt(id);
        return this.friendService.findPendingRequests(myId);
    }
    @GetMapping("/friends/friends/{id}")
    List<Friend> findFriends(@PathVariable String id){
        int myId = Integer.parseInt(id);
        return this.friendService.findFriends(myId);
    }

    @DeleteMapping("/friends/{id}/{friendId}")
    int declineFriend(@RequestParam(required = true) String status, @PathVariable String id, @PathVariable String friendId){
        return this.friendService.declineFriend(Integer.parseInt(id), Integer.parseInt(friendId), status);
    }

    @PutMapping("/friends")
    int acceptFriend(@RequestBody Friend friend){
        System.out.println("Called! " + friend.toString());
        return this.friendService.acceptFriend(friend.getUserid(), friend.getFriend_id());
    }
}
