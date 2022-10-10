package dev.terry.services;

import dev.terry.entities.Friend;
import dev.terry.repos.FriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    FriendRepo friendRepo;

    @Override
    public boolean checkIfAlreadyExists(int myId, int friendId) {
        if(friendRepo.checkIfAlreadyExists(myId, friendId).size() > 0){
            //already exists
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int addFriend(int myId, int friendId) {
        if(!checkIfAlreadyExists(myId, friendId)){
            return this.friendRepo.addFriend(myId, friendId);
        }
        //return already exists exception
        return -1;
    }

    @Override
    public List<Friend> getFriendsByStatus(int id, String status) {
        return this.friendRepo.findByStatus(id, status);
    }

    @Override
    public int declineFriend(int myId, int friendId) {
        if(checkIfAlreadyExists(myId, friendId))
        {
            return this.friendRepo.declineFriend(myId, friendId);
        }
        return -1;
    }

    @Override
    public int acceptFriend(int myId, int friendId) {
        if(checkIfAlreadyExists(myId, friendId)){
            return this.friendRepo.acceptFriend(myId, friendId);
        }
        return -1;
    }

}
