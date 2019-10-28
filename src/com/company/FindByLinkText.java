package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FindByLinkText {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String baseUrl = "https://letskodeit.teachable.com";
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.partialLinkText("Pract")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(3000);

        driver.quit();
    }
}
