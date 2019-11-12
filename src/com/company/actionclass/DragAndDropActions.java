package com.company.actionclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDropActions {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://jqueryui.com/droppable/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testDragAndDrop() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.switchTo().frame(0);

        WebElement fromElement = driver.findElement(By.id("draggable"));
        WebElement toElement = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);

        //There are two ways to drag and drop:
        //1) Drag and drop
        //action.dragAndDrop(fromElement, toElement).build().perform();

        //2) Click and hold, move to element, release, build and perform
        action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
