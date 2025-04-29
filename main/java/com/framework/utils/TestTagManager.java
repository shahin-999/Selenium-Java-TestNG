package com.framework.utils;

import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestTagManager {
    private static final Map<String, String[]> TAG_MAPPINGS = new HashMap<>();

    static {
        // Define your tag mappings here
        TAG_MAPPINGS.put("smoke", new String[]{"Smoke Tests"});
        TAG_MAPPINGS.put("login", new String[]{"Login Tests"});
        TAG_MAPPINGS.put("regression", new String[]{"Regression Tests"});
        TAG_MAPPINGS.put("api", new String[]{"API Tests"});
        TAG_MAPPINGS.put("ui", new String[]{"UI Tests"});
        // Add more mappings as needed
    }

    public static void assignTags(Method testMethod) {
        Test testAnnotation = testMethod.getAnnotation(Test.class);
        if (testAnnotation != null) {
            String[] groups = testAnnotation.groups();
            if (groups.length > 0) {
                // Get all ExtentReports tags for the TestNG groups
                String[] extentTags = Arrays.stream(groups)
                        .filter(TAG_MAPPINGS::containsKey)
                        .flatMap(group -> Arrays.stream(TAG_MAPPINGS.get(group)))
                        .toArray(String[]::new);

                if (extentTags.length > 0) {
                    ExtentReportManager.getTest().assignCategory(extentTags);
                }
            }
        }
    }
} 