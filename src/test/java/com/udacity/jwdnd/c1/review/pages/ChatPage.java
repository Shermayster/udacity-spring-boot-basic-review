package com.udacity.jwdnd.c1.review.pages;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {
    @FindBy(id = "messageText")
    private WebElement messageText;

    @FindBy(id = "submitButton")
    private WebElement submitButton;

    @FindBy(id ="no-history")
    private WebElement noHistory;

    @FindBy(id = "sign-out")
    private  WebElement signOutBtn;

    @FindAll(@FindBy(className = "chat-message-container"))
    private WebElement[] chatMsgContainers;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void postMessage(String messageText) {
        this.messageText.sendKeys(messageText);
        this.submitButton.click();
    }

    public boolean isNoHistoryInDocument() {
        return this.noHistory.isDisplayed();
    }

    public int countMessages() {
        return this.chatMsgContainers.length;
    }

    public void signOut() {
        this.signOutBtn.click();
    }
}
