package com.tests;

import com.framework.base.BaseTest;
import com.framework.pages.LoginPage;
import com.framework.utils.ExcelReader;
import com.framework.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        ExcelReader reader = new ExcelReader("main/resources/testdata/TestData.xlsx");
        return reader.getSheetData("Login");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, String expectedTitle) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        String actualTitle = loginPage.getPageTitle();
        ExtentReportManager.getTest().info("Logged in with username: " + username);
        logger.info("Logged in with username: " + username);
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch after login");
    }
} 