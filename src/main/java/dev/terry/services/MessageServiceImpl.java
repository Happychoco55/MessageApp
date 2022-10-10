package dev.terry.services;

import dev.terry.entities.Message;
import dev.terry.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageRepo messageRepo;

    @Override
    public Message sendMessage(Message message) {
        return this.messageRepo.save(message);
    }

    @Override
    public List<Message> getAllMessagesBetweenUsers(int id, int friendId) {
        return this.messageRepo.getMessagesBetweenUsers(id, friendId);
    }
}
