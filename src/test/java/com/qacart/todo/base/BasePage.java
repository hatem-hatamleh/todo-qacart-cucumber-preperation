package com.qacart.todo.base;

import com.qacart.todo.constants.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo(String url) {
        driver.get(URL.BASE_URL + url);
    }

}
