package dev.terry.repos;

import dev.terry.entities.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FriendRepo extends JpaRepository<Friend, Integer> {
    @Query(value = "select * from friendlist where my_id = :myid and friend_id = :friendid or my_id = :friendid and friend_id = :myid", nativeQuery = true)
    List<Friend> checkIfAlreadyExists(@Param("myid") int myId, @Param("friendid") int friendId);

    @Query(value = "insert into friendlist values(default, :myid, :friendid, 'Pending'), (default, :friendid, :myid, 'Pending')", nativeQuery = true)
    @Modifying
    @Transactional
    int addFriend(@Param("myid") int myId, @Param("friendid") int friendId);

    //Get by status
    @Query(value = "select * from friendList where my_id = :myid and status = :status", nativeQuery = true)
    List<Friend> findByStatus(@Param("myid") int myId, @Param("status") String status);

    @Query(value = "delete from friendlist where my_id = :myid and friend_id = :friendid or my_id = :friendid and friend_id = :myid and status = 'Pending'", nativeQuery = true)
    @Modifying
    @Transactional
    int declineFriend(@Param("myid") int myId, @Param("friendid") int friendId);

    @Query(value = "update friendlist set status = 'Friends' where my_id = :myid and friend_id = :friendid or my_id = :friendid and friend_id = :myid", nativeQuery = true)
    @Modifying
    @Transactional
    int acceptFriend(@Param("myid") int myId, @Param("friendid") int friendId);
}
