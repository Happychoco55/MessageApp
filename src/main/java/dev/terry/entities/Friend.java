package dev.terry.entities;

import dev.terry.entities.enums.Status;

import javax.persistence.*;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "my_id")
    private int userid;

    @Column(name = "friend_id")
    private int friend_id;

    @Column(name = "status")
    private String status;

    public Friend() {
    }

    public Friend(int id, int userid, int friend_id, String status) {
        this.id = id;
        this.userid = userid;
        this.friend_id = friend_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FriendList{" +
                "userid=" + userid +
                ", friend_id=" + friend_id +
                ", status=" + status +
                '}';
    }
}
