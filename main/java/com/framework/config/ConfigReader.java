package com.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("main/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file.", e);
        }
    }

    static String env = getProperty("env");

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return getProperty(env + ".baseUrl");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }
} 