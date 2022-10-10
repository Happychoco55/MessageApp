package dev.terry.entities;

import javax.persistence.*;

@Entity
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int messageId;

    @Column(name = "sender")
    private int sender;

    @Column(name = "receiver")
    private int receiver;

    @Column(name = "epoch_time")
    private int epochTime;

    @Column(name = "contents")
    private String contents;

    public Message() {
    }

    public Message(int messageId, int sender, int receiver, int epochTime, String contents) {
        this.messageId = messageId;
        this.sender = sender;
        this.receiver = receiver;
        this.epochTime = epochTime;
        this.contents = contents;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public int getEpochTime() {
        return epochTime;
    }

    public void setEpochTime(int epochTime) {
        this.epochTime = epochTime;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", epochTime=" + epochTime +
                ", contents='" + contents + '\'' +
                '}';
    }
}
