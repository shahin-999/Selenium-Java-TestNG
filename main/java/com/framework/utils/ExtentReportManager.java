package com.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.config.ConfigReader;
import java.io.File;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.HashMap;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static Map<String, Integer> testStats = new HashMap<>();

    public static void startTest(String testName) {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/extent-reports/ExtentReport.html");
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Web Automation Results");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            
            // Initialize test statistics
            testStats.put("Total", 0);
            testStats.put("Passed", 0);
            testStats.put("Failed", 0);
            testStats.put("Skipped", 0);
            
            // Add system information
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("OS Version", System.getProperty("os.version"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("User Name", System.getProperty("user.name"));
            
            try {
                extent.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
            } catch (Exception e) {
                extent.setSystemInfo("Host Name", "Unknown");
            }
            
            // Add test environment information
            extent.setSystemInfo("Environment", ConfigReader.getProperty("env"));
            extent.setSystemInfo("Base URL", ConfigReader.getProperty("baseUrl"));
            extent.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
            
            // Add report generation time
            String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            extent.setSystemInfo("Report Generated On", currentTime);
        }
        test.set(extent.createTest(testName));
        testStats.put("Total", testStats.get("Total") + 1);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void endTest() {
        test.remove();
    }

    public static void updateTestStats(String status) {
        testStats.put(status, testStats.get(status) + 1);
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static void attachScreenshot(String screenshotPath, String message) {
        try {
            if (getTest() != null && screenshotPath != null) {
                getTest().info(message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (Exception e) {
            if (getTest() != null) {
                getTest().fail("Failed to attach screenshot: " + e.getMessage());
            }
        }
    }

    public static void addTestStep(String stepName, String stepDescription) {
        if (getTest() != null) {
            getTest().info(stepName + ": " + stepDescription);
        }
    }

    public static void addTestCategory(String category) {
        if (getTest() != null) {
            getTest().assignCategory(category);
        }
    }

    public static void addTestAuthor(String author) {
        if (getTest() != null) {
            getTest().assignAuthor(author);
        }
    }
} 