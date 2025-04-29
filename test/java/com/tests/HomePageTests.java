package com.tests;

import com.framework.base.BaseTest;
import com.framework.pages.HomePage;
import com.framework.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    @Test (description = "Test will be failed")
    public void testWelcomeMessage() {
        String welcomeMsg = "wer";
        ExtentReportManager.getTest().info("Welcome message: " + welcomeMsg);
        logger.info("Welcome message: " + welcomeMsg);
        Assert.assertTrue(welcomeMsg.contains("Welcome"), "Welcome message not found!");
    }


    @Test
    public void passtest() {
        String welcomeMsg = "Welcome";
        ExtentReportManager.getTest().info("Welcome message: " + welcomeMsg);
        logger.info("Welcome message: " + welcomeMsg);
        Assert.assertTrue(welcomeMsg.contains("Welcome"), "Welcome message not found!");
    }

    @Test (description = "Swag Labs Test")
    public void swagLabsHomePageTest() {
        HomePage homePage = new HomePage(driver);
        String pageTitle = homePage.getPageTitle();
        ExtentReportManager.getTest().info("Page title: " + pageTitle);
        logger.info("Page tile: " + pageTitle);
        Assert.assertTrue(pageTitle.contains("Swag Labs"), "Page title not found");
    }

} 