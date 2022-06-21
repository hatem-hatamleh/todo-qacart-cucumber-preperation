package com.qacart.todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this );
    }

    @FindBy(css="[data-testid=\"email\"]")
    private WebElement loginInput;

    @FindBy(css="[data-testid=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css="[data-testid=\"submit\"]")
    private WebElement submit;


    // Login method
    public void login() {
        loginInput.sendKeys("hatem@example.com");
        passwordInput.sendKeys("123456");
        submit.click();
    }

}
