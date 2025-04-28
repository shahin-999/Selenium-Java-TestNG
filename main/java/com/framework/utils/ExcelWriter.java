package com.framework.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {
    public static void createTestDataFile(String filePath) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Login");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("username");
            headerRow.createCell(1).setCellValue("password");
            headerRow.createCell(2).setCellValue("expectedTitle");

            // Add test data
            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("admin");
            row1.createCell(1).setCellValue("admin123");
            row1.createCell(2).setCellValue("Dashboard");

            Row row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue("user");
            row2.createCell(1).setCellValue("user123");
            row2.createCell(2).setCellValue("Home");

            Row row3 = sheet.createRow(3);
            row3.createCell(0).setCellValue("test");
            row3.createCell(1).setCellValue("test123");
            row3.createCell(2).setCellValue("Welcome");

            // Write to file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to create test data file", e);
        }
    }
} 