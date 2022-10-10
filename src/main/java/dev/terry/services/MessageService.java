package dev.terry.services;

import dev.terry.entities.Message;

import java.util.List;

public interface MessageService {

    Message sendMessage(Message message);

    List<Message> getAllMessagesBetweenUsers(int id, int friendId);
}
