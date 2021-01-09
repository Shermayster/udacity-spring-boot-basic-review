package com.udacity.jwdnd.c1.review.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
        @FindBy(id = "inputUsername")
        private WebElement inputUsername;

        @FindBy(id = "inputPassword")
        private WebElement inputPassword;

        @FindBy(id = "submitButton")
        private WebElement submitButton;

        @FindBy(id ="signup-link")
        private  WebElement signUpLink;

        public LoginPage(WebDriver driver) {
                PageFactory.initElements(driver, this);
        }

        public void login(String username, String password) {
                this.inputUsername.sendKeys(username);
                this.inputPassword.sendKeys(password);
                this.submitButton.click();
        }

        public void goToSignUp() {
                this.signUpLink.click();
        }
}
