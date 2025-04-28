package com.tests;

import com.framework.base.BaseTest;
import com.framework.pages.HomePage;
import com.framework.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    @Test (description = "New Test File")
    public void testWelcomeMessage() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        String welcomeMsg = "wer";
        ExtentReportManager.getTest().info("Welcome message: " + welcomeMsg);
        logger.info("Welcome message: " + welcomeMsg);
        Assert.assertTrue(welcomeMsg.contains("Welcome"), "Welcome message not found!");
    }


    @Test (description = "New Test File")
    public void testWelcomeMessage1() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        String welcomeMsg = "Welcome";
        ExtentReportManager.getTest().info("Welcome message: " + welcomeMsg);
        logger.info("Welcome message: " + welcomeMsg);
        Assert.assertTrue(welcomeMsg.contains("Welcome"), "Welcome message not found!");
    }

    @Test (description = "New Test File")
    public void testWelcomeMessage2() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        String welcomeMsg = "wer";
        ExtentReportManager.getTest().info("Welcome message: " + welcomeMsg);
        logger.info("Welcome message: " + welcomeMsg);
        Assert.assertTrue(welcomeMsg.contains("Welcome"), "Welcome message not found!");
    }

} 