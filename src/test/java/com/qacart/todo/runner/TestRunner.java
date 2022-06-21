package com.qacart.todo.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/qacart/todo/features",
        glue = "com/qacart/todo",
        plugin = {"html:target/report/report.html"}
)
public class TestRunner {
}
