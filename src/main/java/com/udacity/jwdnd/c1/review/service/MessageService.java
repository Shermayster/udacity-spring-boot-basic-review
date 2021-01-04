package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.model.ChatMessageMapper;
import com.udacity.jwdnd.c1.review.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MessageService {
    String message;
    private final ChatMessageMapper chatMessageMapper;
    public MessageService (String message, ChatMessageMapper chatMessageMapper) {
        this.chatMessageMapper = chatMessageMapper;
        this.message = message;
    }
    public String uppercase() {
        return this.message.toUpperCase();
    }
    public String lowercase() {
        return this.message.toLowerCase();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Message service created");
    }

    public void addMessage(String messageText, String username) {
        this.chatMessageMapper.insert(new ChatMessage(null, messageText, username));
    }


    public List<ChatMessage> getChatHistory() {
        return Arrays.asList(this.chatMessageMapper.getUserMessages());
    }

}