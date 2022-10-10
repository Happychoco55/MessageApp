package dev.terry.repos;

import dev.terry.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {
    @Query(value = "select * from message where sender = :myid and receiver = :friendid or sender = :friendid and receiver = :myid order by epoch_time asc", nativeQuery = true)
    List<Message> getMessagesBetweenUsers(@Param("myid") Integer id, @Param("friendid") Integer friendId);
}
