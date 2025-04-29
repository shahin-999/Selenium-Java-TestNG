package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By welcomeMessage = By.id("welcomeMsg");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
} 