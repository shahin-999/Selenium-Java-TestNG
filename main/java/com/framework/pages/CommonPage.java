package com.framework.pages;

import org.openqa.selenium.WebDriver;

public class CommonPage {
    WebDriver driver;
    public CommonPage (WebDriver driver){
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    public String getPageCurrentURL(){
        return driver.getCurrentUrl();
    }
}
