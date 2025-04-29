package com.tests;

import com.framework.base.BaseTest;
import com.framework.pages.CommonPage;
import com.framework.pages.LoginPage;
import com.framework.utils.ExcelReader;
import com.framework.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    ExcelReader excelReaderLoginTestData = new ExcelReader("main/resources/testdata/TestLoginData.xlsx");
    String loginSheet = "Login";
    /*
    * Initialize Pages
    * */
    CommonPage common;
    LoginPage loginPage;

    @Test (description = "Customer login to the site successfully.",
           groups = {"smoke", "login", "regression"})
    public void TestSuccessfulLogin(){
        common = new CommonPage(driver);
        loginPage = new LoginPage(driver);

        String userName = excelReaderLoginTestData.getCellData(loginSheet, "username",2);
        String password = excelReaderLoginTestData.getCellData(loginSheet, "password",2);
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String currentURL = common.getPageCurrentURL();

        ExtentReportManager.getTest().info("Page current URL: " + currentURL);
        logger.info("Page current URL: " + currentURL);

        Assert.assertTrue(currentURL.contains("inventory"), "Page url does not matched. Login failed");
    }
}
