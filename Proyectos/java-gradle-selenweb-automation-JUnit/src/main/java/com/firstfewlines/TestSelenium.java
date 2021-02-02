package com.firstfewlines;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class TestSelenium {

    public static void main(String[] argv) throws Exception {

        WebDriver webDriver = new ChromeDriver();

        //webDriver.navigate().to(new URL("https://www.google.com"));
        webDriver.get("https://www.google.com");


        WebDriverWait wait = new WebDriverWait(webDriver, 10000);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("input"), 0));

        // WebElement input = webDriver.findElement(By.cssSelector("gLFyf gsfi"));
        WebElement input = webDriver.findElement(By.name("q"));

        input.sendKeys("Spark Java file upload example - First Few Lines");
        input.sendKeys(Keys.ENTER);

        webDriver.quit();
    }
}
