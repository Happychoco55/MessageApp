package dev.terry.controllers;

import dev.terry.entities.Friend;
import dev.terry.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
public class FriendController {

    @Autowired
    FriendService friendService;

    @PostMapping("/friends/{myId}/{friendId}")
    int addFriend(@PathVariable String myId, @PathVariable String friendId){
        int id = Integer.parseInt(myId);
        int friend = Integer.parseInt(friendId);
        int success = this.friendService.addFriend(id, friend);
        if(success <= 0){
            //Unsuccessful
            return success;
        }
        else{
            //Successful
            return success;
        }
    }

    @GetMapping("/friends/{id}")
    List<Friend> getFriendsByStatus(@PathVariable String id, @RequestParam(required = true) String status){
        int myId = Integer.parseInt(id);
        return this.friendService.getFriendsByStatus(myId, status);
    }

    @DeleteMapping("/friends/{id}/{friendId}")
    int declineFriend(@PathVariable String id, @PathVariable String friendId){
        int myId = Integer.parseInt(id);
        int friend = Integer.parseInt(friendId);

        return this.friendService.declineFriend(myId, friend);
    }

    @PutMapping("/friends/{id}/{friendId}")
    int acceptFriend(@PathVariable String id, @PathVariable String friendId){
        int myId = Integer.parseInt(id);
        int friend = Integer.parseInt(friendId);

        return this.friendService.acceptFriend(myId, friend);
    }
}
