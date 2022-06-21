package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TodoPage extends BasePage {


    @FindBy(css="[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;

    @FindBy(css="[data-testid=\"add\"]")
    private WebElement plusButton;

    @FindBy(css="[data-testid=\"todo-item\"]")
    private List<WebElement> todoItems;

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    public NewTodoPage clickOnPlusButton() {
        plusButton.click();
        return new NewTodoPage(driver);
    }

    public boolean welcomeMessageIsDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    public String firstItemText() {
        return todoItems.get(0).getText();
    }





}
