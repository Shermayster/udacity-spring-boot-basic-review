package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.model.User;
import com.udacity.jwdnd.c1.review.pages.ChatPage;
import com.udacity.jwdnd.c1.review.pages.LoginPage;
import com.udacity.jwdnd.c1.review.pages.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {
    private static WebDriver driver;
    @LocalServerPort
    private Integer port;
    private SignupPage signupPage;
    private LoginPage loginPage;
    private ChatPage chatPage;
    private final User testUser = new User(null, "test", "test", "test", "test", "test");

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("port: " + port);
        driver.get("http://localhost:" + port + "/signup");
        signupPage = new SignupPage(driver);
        loginPage = new LoginPage(driver);
        chatPage = new ChatPage(driver);
    }

    @Test
    public void addMessage() {
        this.signupPage.signupUser(testUser);
		assertTrue(this.signupPage.getSignupSuccess().isDisplayed());
		this.signupPage.goToLoginPage();
		this.loginPage.login("test", "test");
        assertTrue(this.chatPage.isNoHistoryInDocument());
		this.chatPage.postMessage("hi from test");
		assertFalse(chatPage.isNoHistoryInDocument());

    }

}