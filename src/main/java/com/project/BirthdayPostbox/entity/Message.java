package com.project.BirthdayPostbox.entity;

public class Message {
    private String messageId;

    private String roomId;

    private String messageSender;

    private String messageContent;

    public Message(String messageId, String roomId, String messageSender, String messageContent) {
        this.messageId = messageId;
        this.roomId = roomId;
        this.messageSender = messageSender;
        this.messageContent = messageContent;
    }

    public String getMessageId() { return messageId; }

    public void setMessageId(String messageId) { this.messageId = messageId; }

    public String getRoomId() { return roomId; }
    
    public void setRommId(String roomId) { this.roomId = roomId; }

    public Stirng getMessageSender() { return messageSender; }

    public void setMessageSender(String messageSender) { this.messageSender = messageSender; }

    public String getMessageContent() { return messageContent; }

    public void setMessageSender(String messageSender) { this.messageSender = messageSender; }
}
