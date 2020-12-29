package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    String message;
    public MessageService (String message) {
        this.message = message;
    }
    public String uppercase() {
        return this.message.toUpperCase();
    }
    public String lowercase() {
        return this.message.toLowerCase();
    }
    private List<ChatMessage> chatHistory;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Message service created");
        chatHistory = new ArrayList<>();
    }

    public void addMessage(ChatMessage msg) {
        this.chatHistory.add(msg);
    }


    public List<ChatMessage> getChatHistory() {
        return this.chatHistory;
    }

}