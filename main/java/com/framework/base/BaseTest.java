package com.framework.base;

import com.framework.config.ConfigReader;
import com.framework.utils.ExtentReportManager;
import com.framework.utils.ScreenshotUtil;
import com.framework.utils.ExcelWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected Logger logger;
    private long startTime;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser, ITestResult result) {
        logger = LogManager.getLogger(this.getClass());
        BrowserFactory.initDriver(browser);
        driver = BrowserFactory.getDriver();
        
        // Get test description and method name from @Test annotation
        String testDescription = "";
        String testMethodName = "";
        if (result != null && result.getMethod() != null) {
            testDescription = result.getMethod().getDescription();
            testMethodName = result.getMethod().getMethodName();
        }
        
        ExtentReportManager.startTest(this.getClass().getSimpleName(), testDescription, testMethodName, browser);
        startTime = System.currentTimeMillis();
        
        // Add test metadata
        ExtentReportManager.addTestCategory("Web UI Tests");
        ExtentReportManager.addTestAuthor("Automation Team");
        ExtentReportManager.addTestStep("Test Setup", "Initializing browser: " + browser);

        // Navigate to the Base URL
        String baseURL = ConfigReader.getBaseUrl();
        try {
            if (baseURL != null && !baseURL.isBlank()){
                driver.navigate().to(baseURL);
            }else {
                logger.error("Base url is null, empty, or blank");
                ExtentReportManager.getTest().fail("Base url is null, empty, or blank");
            }

        } catch (Exception e) {
            logger.error("Unable to navigate to the URL: "+ baseURL);
            ExtentReportManager.getTest().fail("Unable to navigate to the URL: "+ baseURL);
            throw new RuntimeException(e);
        }
    }

    @BeforeSuite
    public void setupSuite() {
        ScreenshotUtil.clearScreenshots();
        ExcelWriter.createTestDataFile("main/resources/testdata/TestData.xlsx");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        String testName = result.getName();
        long executionTime = System.currentTimeMillis() - startTime;
        
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, testName);
            logger.error("Test failed: " + testName);
            ExtentReportManager.getTest().fail("❌ Test Failed. 😔 Check the screenshot for details. Screenshot: " + screenshotPath);
            ExtentReportManager.attachScreenshot(screenshotPath, "Test Failed: " + testName);
            ExtentReportManager.updateTestStats("Failed");
            
            if (result.getThrowable() != null) {
                ExtentReportManager.addTestStep("Failure Details", result.getThrowable().getMessage());
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("Test passed: " + testName);
            ExtentReportManager.getTest().pass("✅ Test Passed Successfully! 🎉");
            ExtentReportManager.updateTestStats("Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.warn("Test skipped: " + testName);
            ExtentReportManager.getTest().skip("⚠️ Test Skipped");
            ExtentReportManager.updateTestStats("Skipped");
        }
        
        ExtentReportManager.addTestStep("Test Cleanup", "Closing browser and cleaning up resources");
        ExtentReportManager.addTestStep("Execution Time", executionTime + " ms");
        BrowserFactory.quitDriver();
        ExtentReportManager.endTest();
    }

    @AfterSuite(alwaysRun = true)
    public void flushReport() {
        ExtentReportManager.flushReports();
    }
} 