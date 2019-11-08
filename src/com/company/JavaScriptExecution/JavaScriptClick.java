package com.company.JavaScriptExecution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/* It's better to not use the JS click() by default, only when the traditional Selenium click() doesn't work.
This could happen when elements are overlapped.
 */
public class JavaScriptClick {
    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testJSClick1() throws Exception {
        driver.get("https://letskodeit.teachable.com/pages/practice");
        Thread.sleep(3000);

        WebElement checkBoxElement = driver.findElement(By.id("bmwcheck"));
        js.executeScript("arguments[0].click();", checkBoxElement);
    }

    @After
    public void tearDown() throws Exception {
    }
}
