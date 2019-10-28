package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasicActions {

    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[@id=\"navbar\"]//a[@href=\"/sign_in\"]")).click();
        System.out.println("Clicked on login!");
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("test@test.com");
        System.out.println("Writing some email...");
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("lalala");
        System.out.println("Writing some password...");
        driver.findElement(By.id("user_email")).clear();
        System.out.println("Clearing email field");
        driver.findElement(By.id("user_password")).clear();
        System.out.println("Clearing password field");
        Thread.sleep(3000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
