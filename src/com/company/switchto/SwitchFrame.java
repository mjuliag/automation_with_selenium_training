package com.company.switchto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
IFrame is a page inside the same page, in the same browser. Selenium doesn't reconize  the elements inside an IFrame
just like it doesn't recognize the elements of another browser. We need to tell the driver to switch to the IFrame.
 */
public class SwitchFrame {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(3000);
        // We can switch between frames using different properties!
        // 1) Switch to frame by Id
        driver.switchTo().frame("courses-iframe");

        // 2) Switch to frame by name
        //driver.switchTo().frame("iframe-name");

        /* 3) Switch to frame by numbers, which is the index of the frame. We can try and figure it out with different
        numbers when we have more than one frame, but usually we don't have a lot of them in a website, so we can start
        trying with 0 which is the first position.
        We use this when we don't have an ID nor a name!:
        driver.switchTo().frame(0);
         */

        WebElement searchBox = driver.findElement(By.id("search-courses"));
        searchBox.sendKeys("python");

        //We don't use handles in this case, we use defaultContent() which is the parent window!!
        driver.switchTo().defaultContent();
        Thread.sleep(6000);
        driver.findElement(By.id("name")).sendKeys("Test Successful");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(10000);
        driver.quit();
    }
}
