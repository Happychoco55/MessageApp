package dev.terry.controllers;

import dev.terry.entities.Message;
import dev.terry.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/messages")
    public Message sendMessage(@RequestBody Message message){
        return this.messageService.sendMessage(message);
    }

    @GetMapping("/messages/{id}/{friendId}")
    public List<Message> getMessagesBetweenUsers(@PathVariable String id, @PathVariable String friendId){
        int parsedId = Integer.parseInt(id);
        int parsedFriendId = Integer.parseInt(friendId);
        return this.messageService.getAllMessagesBetweenUsers(parsedId, parsedFriendId);
    }

}
