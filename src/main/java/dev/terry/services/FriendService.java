package dev.terry.services;

import dev.terry.entities.Friend;

import java.util.List;

public interface FriendService {

    boolean checkIfAlreadyExists(int myId, int friendId);

    int addFriend(int myId, int friendId);

    List<Friend> getFriendsByStatus(int id, String status);

    int declineFriend(int myId, int friendId);

    int acceptFriend(int myId, int friendId);
}
