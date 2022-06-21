package com.qacart.todo.steps;

import com.qacart.todo.constants.Task;
import com.qacart.todo.constants.User;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class TodoSteps {

    WebDriver driver;
    LoginPage loginPage;
    TodoPage todoPage;
    NewTodoPage newTodoPage;

    @Given("User is in todo page")
    public void user_is_in_todo_page() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.goTo("/");
        todoPage = loginPage.login(User.EMAIL, User.PASSWORD);

    }

    @When("User add a new todo")
    public void user_add_a_new_todo() {
        newTodoPage = todoPage.clickOnPlusButton();
        newTodoPage.addNewToDo(Task.TITLE);
    }

    @Then("The added todo should be displayed correctly")
    public void the_added_todo_should_be_displayed_correctly() {
        Assert.assertEquals(todoPage.firstItemText() , Task.TITLE);
    }

}
