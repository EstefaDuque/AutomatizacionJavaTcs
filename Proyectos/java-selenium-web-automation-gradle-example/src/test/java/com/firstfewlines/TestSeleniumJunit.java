package com.firstfewlines;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSeleniumJunit {
    WebDriver webDriver;

    @Before
    public void abrirDriver(){webDriver = new ChromeDriver();}

    @Test
    public void abrirAplicacion() throws MalformedURLException {
        webDriver.navigate().to(new URL("https://www.google.com"));
    }

    @Test
    public void esperarNavegador(){
        WebDriverWait wait = new WebDriverWait(webDriver, 20000);
        //Hasta que no encuentre el input q
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("input"),0));
    }

    @Test
    public void ingresarBusquedad(){
        WebElement input = webDriver.findElement(By.name("q"));

        input.sendKeys(("Spark Java file upload example - First Few Lines"));
        input.sendKeys(Keys.ENTER);

    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
