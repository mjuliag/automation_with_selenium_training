package com.company.interviewquestions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/* The literal meaning of stale is "not freshed" and "not new". In Selenium WebDriver perspective it means that the
element it's not new or fresh and it has become stale. This may happen when we find and element and do some kind of
interaction that causes the page to reload or to change, which causes that the DOM is created again! We need to make
sure that we find the element when we actually are going to need it!
 */
public class StaleElementDemo {

    @Test
    public void testMethod() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://learn.letskodeit.com/p/practice");

        WebElement checkboxElement = driver.findElement(By.id("bmwcheck"));
        //This refreshes the page and the DOM is created again and give us the StaleElementException
        driver.get(driver.getCurrentUrl());
        checkboxElement.click();
    }
}