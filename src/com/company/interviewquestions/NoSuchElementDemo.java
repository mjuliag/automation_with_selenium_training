package com.company.interviewquestions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class NoSuchElementDemo {


    //There are 3 main reasons why we see this exception:
    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://learn.letskodeit.com";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(baseUrl);

        /* 1. Timing Issues. This happens when Selenium tries to find an element but it still hasn't render in the
        application. This test demo works with the implicitlyWait line commented out, but even with implicit waits
        some elements take more time to wait, in that case we can use an explicit wait (WebDriverWait).
         */
        driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        //WebElement emailField = driver.findElement(By.id("user_email"));
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
        emailField.sendKeys("testing");

        /* 2. Incorrect locator or type of locator. This may happen when we want to find an element that changed
        it's locator because maybe we're at the wrong page. For this element, at this point, the href is completely
        different that it was a few lines before: "//a[@href='/sign_in']", that xpath fails, so I changed it.
         */
        driver.findElement(By.xpath("//input[@value=\"Log In\"]")).click();

        // 3. Element is in iFrame
        driver.get("https://learn.letskodeit.com/p/practice");
        //We need to switch to the iFrame first to find the element
        driver.switchTo().frame("courses-iframe");
        driver.findElement(By.id("search-courses")).sendKeys("Java");
        driver.switchTo().defaultContent();
    }
}
