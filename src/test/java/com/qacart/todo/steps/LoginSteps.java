package com.qacart.todo.steps;

import com.qacart.todo.constants.User;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    TodoPage todoPage;

    @Given("User is in the login page")
    public void user_is_in_login_page() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.goTo("/");
    }

    @When("User fill the login form and submit")
    public void user_fill_login_form_and_submit() {
        todoPage = loginPage.login(User.EMAIL, User.PASSWORD);
    }

    @Then("User should navigate to the todo page")
    public void user_should_navigate_to_the_todo_page() {
        Assert.assertTrue(todoPage.welcomeMessageIsDisplayed());
    }

}
