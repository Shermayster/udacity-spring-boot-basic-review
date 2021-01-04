package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {
    private Integer messageid;
    private String messageText;
    private String username;

    public ChatMessage(Integer messageId, String text, String username) {
        this.setMessageText(text);
        this.setUsername(username);
        this.messageid = messageId;
    }

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
