package com.tests;

import com.framework.utils.ExcelWriter;
import org.testng.annotations.BeforeSuite;

public class TestDataSetup {
    @BeforeSuite
    public void setupTestData() {
        // Create test data Excel file
        ExcelWriter.createTestDataFile("main/resources/testdata/TestData.xlsx");
    }
} 