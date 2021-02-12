package com.firstfewlines;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumSampleJUnit {

    WebDriver webDriver;

    @Before
    public void setUp() { webDriver = new ChromeDriver(); }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void openApplication() throws MalformedURLException {
        webDriver.navigate().to(new URL("https://www.google.com"));
    }

    @Test
    public void waitNavigation(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10000);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.tagName("input"), 0));
    }


}
