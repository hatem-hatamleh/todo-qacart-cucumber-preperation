package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTodoPage extends BasePage {

    @FindBy(css="[data-testid=\"new-todo\"]")
    private WebElement newTodoInput;

    @FindBy(css="[data-testid=\"submit-newTask\"]")
    private WebElement newTodoSubmitButton;

    public NewTodoPage(WebDriver driver) {
        super(driver);
    }


    public TodoPage addNewToDo(String task) {
        newTodoInput.sendKeys(task);
        newTodoSubmitButton.click();
        return new TodoPage(driver);
    }

}
