package com.framework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ScreenshotUtil {
    private static final String SCREENSHOT_DIR = "reports/extent-reports/screenshots/";
    
    static {
        // Create screenshot directory if it doesn't exist
        try {
            Files.createDirectories(Paths.get(SCREENSHOT_DIR));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Generate unique filename with timestamp and UUID
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String uniqueId = UUID.randomUUID().toString().substring(0, 8);
            String filename = String.format("%s_%s_%s.png", screenshotName, timestamp, uniqueId);
            String destPath = SCREENSHOT_DIR + filename;

            // Take screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(srcFile.toPath(), Paths.get(destPath));
            
            return destPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void clearScreenshots() {
        try {
            File dir = new File(SCREENSHOT_DIR);
            if (dir.exists() && dir.isDirectory()) {
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile() && file.getName().endsWith(".png")) {
                            file.delete();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 