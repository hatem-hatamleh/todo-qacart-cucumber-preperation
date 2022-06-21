package com.qacart.todo.steps;

import com.qacart.todo.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver;

    @Given("User is in the login page")
    public void user_is_in_login_page() {
        driver = DriverFactory.initDriver();
        driver.get("https://qacart-todo.herokuapp.com");
    }

    @When("User fill the login form and submit")
    public void user_fill_login_form_and_submit() {
        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("hatem@example.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("123456");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();
    }

    @Then("User should navigate to the todo page")
    public void user_should_navigate_to_the_todo_page() {
        boolean isWelcomeMessageDisplayed = driver.findElement(By.cssSelector("[data-testid=\"welcome\"]")).isDisplayed();
        Assert.assertTrue(isWelcomeMessageDisplayed);
    }
}
