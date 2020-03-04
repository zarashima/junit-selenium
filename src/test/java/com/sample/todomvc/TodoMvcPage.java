package com.sample.todomvc;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class TodoMvcPage implements TodoMvc {

    private final WebDriver driver;
    private static final By byTodoRemove = By.cssSelector("button.destroy");
    private static final By byTodoComplete = By.cssSelector("input.toggle");
    private static final By boTodoEdit = By.cssSelector("input.edit");

    @FindBy(className = "new-todo")
    private WebElement newTodoInput;

    @FindBy(css = ".todo-count > strong")
    private WebElement todoCount;

    @FindBy(css = ".todo-list li")
    private List<WebElement> todos;

    @FindBy(className = "toggle-all")
    private WebElement toggleAll;

    @FindBy(css = "a[href='#/active']")
    private WebElement showActive;

    @FindBy(css = "a[href='#/completed']")
    private WebElement showCompleted;

    @FindBy(className = "clear-completed")
    private WebElement clearCompleted;

    public TodoMvcPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void navigateTo() {
        driver.get("http://todomvc.com/examples/vanillajs/");
    }

    @Override
    public void createTodo(String todoName) {
        newTodoInput.sendKeys(todoName + Keys.ENTER);
    }

    @Override
    public void createTodos(String... todoNames) {
        for (String todoName : todoNames) {
            createTodo(todoName);
        }
    }

    @Override
    public int getTodosLeft() {
        return Integer.parseInt(todoCount.getText());
    }

    @Override
    public boolean todoExists(String todoName) {
        return getTodos().stream().anyMatch(todoName::equals);
    }

    @Override
    public int getTodoCount() {
        return todos.size();
    }

    @Override
    public List<String> getTodos() {
        return todos
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    public void renameTodo(String todoName, String newTodoName) {

    }

    @Override
    public void removeTodo(String todoName) {

    }

    @Override
    public void completeTodo(String todoName) {

    }

    @Override
    public void completeAllTodos() {

    }

    @Override
    public void showActive() {

    }

    @Override
    public void showCompleted() {

    }

    @Override
    public void clearCompleted() {

    }

}
