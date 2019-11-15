package com.company.interviewquestions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ElementNotClickableDemo {

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        /* This may happen when the element is loaded in DOM, but it is overlapped by another element, like maybe a
        spinner or some loading animation for a fraction of a second and the element is not visible because of this
        other element.
         */

        //TODO find a page in which these situation happens!!! For now a leave a potential solutions for this issue
        driver.get("");


        /* What we can do in this case is use an explicit wait to make sure that the element overlapping is invisible
         when Selenium executes the code with invisibilityOfElementLocated:
         */
        WebDriverWait wait = new WebDriverWait(driver, 3);
        boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.id("some id that usually the error logs gives us when it tell us that the element wasn't clickable")));

        /* We find and click the element if the element overlapping it is invisible. This is the most recommendable
        option
         */
        if (invisible) {
            WebElement loginButton = driver.findElement(By.xpath("some xpath"));
            loginButton.click();
        }

        /* We can also use the JS Excutor for this kind of issues. JS will click the element the hard no matter if it's
        overlapped by some other element. This is the second best option tho.
         */
        WebElement loginButtonJS = driver.findElement(By.xpath("some xpath"));
        js.executeScript("arguments[0].click();", loginButtonJS);
    }
}
