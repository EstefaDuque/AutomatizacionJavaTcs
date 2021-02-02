package com.firstfewlines;

import org.junit.*;

import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // La ejecución se realiza por orden Alfabetico de los metodos
public class SeleniumJUnitTest {

    protected static WebDriver webDriver;
    private static String url = "https://www.google.com/";

    @BeforeClass
    public static void abrirDriver() {
        webDriver = new ChromeDriver ();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("abrir ChromeDriver");
    }

    @Test
    public void abrirAplicacion()
    {
        webDriver.get( url );
        System.out.println("abrir Aplicacion: " + url);
    }

    @Ignore
    @Test
    public void ignoreElTest() {
        WebElement input = webDriver.findElement(By.name("q"));

        input.sendKeys("Spark Java file upload example - First Few Lines");
        input.sendKeys(Keys.ENTER);

        System.out.println("ignore El Test");
    }

    @Test
    public void esperarNavegacion() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10000);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("input"), 0));
        System.out.println("esperar Navegacion");
    }

    @Test
    public void ingresarBusqueda() {
        WebElement input = webDriver.findElement(By.name("q"));

        input.sendKeys("Spark Java file upload example - First Few Lines");
        input.sendKeys(Keys.ENTER);

        System.out.println("ingresar Busqueda");
    }

    @AfterClass
    public static void cerrarDriver() {
        webDriver.close();
        webDriver.quit();
        System.out.println("cerrar ChromeDriver");
    }

}
