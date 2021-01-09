package com.udacity.jwdnd.c1.review.pages;

import com.udacity.jwdnd.c1.review.model.User;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    @FindBy(id = "inputFirstName")
    private WebElement inputFirstName;

    @FindBy(id = "inputLastName")
    private WebElement inputLastName;

    @FindBy(id = "inputUsername")
    private WebElement inputUsername;

    @FindBy(id = "inputPassword")
    private WebElement inputPassword;

    @FindBy(id = "submitButton")
    private WebElement submitButton;

    @FindBy(id = "login-link")
    private  WebElement loginLink;

    @FindBy(id ="success-msg")
    private  WebElement signupSuccess;

    public SignupPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void signupUser(@NotNull User user) {
        this.inputFirstName.sendKeys(user.getFirstName());
        this.inputLastName.sendKeys(user.getLastName());
        this.inputUsername.sendKeys(user.getUsername());
        this.inputPassword.sendKeys(user.getPassword());
        this.submitButton.click();
    }

    public WebElement getSignupSuccess() {
        return this.signupSuccess;
    }
    public void goToLoginPage() {
        this.loginLink.click();
    }

}

