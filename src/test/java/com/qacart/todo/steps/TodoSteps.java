package com.qacart.todo.steps;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TodoSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("User is in todo page")
    public void user_is_in_todo_page() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://qacart-todo.herokuapp.com");
        loginPage.login();

    }

    @When("User add a new todo")
    public void user_add_a_new_todo() {
        driver.findElement(By.cssSelector("[data-testid=\"add\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"new-todo\"]")).sendKeys("Learn Selenium");
        driver.findElement(By.cssSelector("[data-testid=\"submit-newTask\"]")).click();
    }

    @Then("The added todo should be displayed correctly")
    public void the_added_todo_should_be_displayed_correctly() {
        String taskText = driver.findElement(By.cssSelector("[data-testid=\"todo-item\"]")).getText();
        Assert.assertEquals(taskText , "Learn Selenium");
    }

}
