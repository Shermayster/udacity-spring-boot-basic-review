package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {
    public String text;
    public String type;
    public String userName;

    public ChatMessage(String text, String type, String userName) {
        this.text = text;
        this.type = type;
        this.userName = userName;
    }
    
}
