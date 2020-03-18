package com.sample.todomvc;

import io.github.bonigarcia.seljup.SingleSession;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SeleniumExtension.class)
@SingleSession
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Managing Todos")
public class TodoMvcTest {

    private final WebDriver driver;
    private TodoMvc todoMvc;

    public TodoMvcTest(ChromeDriver driver) {
        this.driver = driver;
        this.todoMvc = PageFactory.initElements(driver, TodoMvcPage.class);
        this.todoMvc.navigateTo();
    }

    @Test
    @Order(1)
    @DisplayName("Creates Todo with given name")
    void createsTodo() {
        this.todoMvc.createTodos("Buy milk", "Clean up the room", "Read the book");
        assertThat(todoMvc.getTodos())
                .hasSize(3)
                .containsSequence("Buy milk", "Clean up the room", "Read the book");
    }

    @AfterEach
    void storageCleanup() {
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear()");
    }

}
