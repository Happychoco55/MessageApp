package dev.terry.services;

import dev.terry.entities.Friend;

import java.util.List;

public interface FriendService {

    boolean checkIfAlreadyExists(int myId, int friendId);

    int addFriend(int myId, int friendId);

    List<Friend> findPendingRequests(int id);
    List<Friend> findFriends(int id);

    int declineFriend(int myId, int friendId, String status);

    int acceptFriend(int myId, int friendId);
}
