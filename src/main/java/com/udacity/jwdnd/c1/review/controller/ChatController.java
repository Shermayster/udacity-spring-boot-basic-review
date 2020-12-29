package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/chat")
public class ChatController {
    private MessageService messageService;
    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping
    public String getChatPage(@ModelAttribute("newChatMessage") ChatForm newChatMessage, Model model) {
        System.out.println("chat page");
        model.addAttribute("history", this.messageService.getChatHistory());
        return "chat";
    }

    @PostMapping
    public String addMessage(@ModelAttribute("newChatMessage") ChatForm chatForm, Model model) {
        ChatMessage newMsg = new ChatMessage(chatForm.getText(), chatForm.getType(), chatForm.getUserName());
        this.messageService.addMessage(newMsg);
        model.addAttribute("history", this.messageService.getChatHistory());
        this.clearForm(chatForm);
        return "chat";
    }

    @ModelAttribute("allMessagesTypes")
    public String [] allMessageTypes() {
        return new String[] {"Say", "Shout",  "Whisper"};
    }

    private void clearForm(ChatForm chatForm) {
        chatForm.setText("");
        chatForm.setType("");
        chatForm.setUserName("");
    }
}
