package com.qacart.todo.steps;

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

    @Given("User is in todo page")
    public void user_is_in_todo_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://qacart-todo.herokuapp.com");
        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("hatem@example.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("123456");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();


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
