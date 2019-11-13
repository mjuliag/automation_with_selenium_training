package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdXpathDemo {

    public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            String baseUrl = "http://www.google.com";
            driver.manage().window().maximize();
            driver.get(baseUrl);

            driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("letskodeit");
            driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).click();
            driver.quit();
        }
    }

