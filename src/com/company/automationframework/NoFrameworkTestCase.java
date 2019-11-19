package com.company.automationframework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NoFrameworkTestCase {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() {
        driver.findElement(By.id("tab-flight-tab-hp")).click();
        driver.findElement(By.id("flight-origin-hp-flight")).sendKeys("New York");
        driver.findElement(By.id("flight-destination-hp-flight")).sendKeys("Chicago");
        driver.findElement(By.id("flight-departing-hp-flight")).sendKeys("10/28/2014");
        driver.findElement(By.id("flight-returning-hp-flight")).sendKeys("10/31/2014");
        driver.findElement(By.xpath("//*[@id=\"gcw-flights-form-hp-flight\"]/div[7]/label/button")).click();
    }

    @After
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
