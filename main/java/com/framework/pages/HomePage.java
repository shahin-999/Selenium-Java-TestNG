package com.framework.pages;

import com.framework.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By welcomeMessage = By.id("welcomeMsg");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage(){
        driver.navigate().to(ConfigReader.getEnvUrl());
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
} 