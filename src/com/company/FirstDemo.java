package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstDemo {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String baseUrl = "https://learn.letskodeit.com/p/practice";
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.xpath("//table[@id=\"product\"]//td[text()='Python Programming Language']//following-sibling::td"));
        Thread.sleep(2000);
        driver.quit();
    }
}