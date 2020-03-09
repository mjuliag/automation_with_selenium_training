package com.company.cucumberdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/*
I didn't need to run this as a TestNG suite. Just running it from the class itselfs works fine and generates the
extent report as expected in the filepath provided.
 */
public class SeleniumLoginTest {

    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        baseUrl = "http://www.letskodeit.com/";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        dimissPopUp();
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
        signupLink.click();

        WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        loginLink.click();

        WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
        emailField.sendKeys("test@email.com");

        WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
        passwordField.sendKeys("abcabc");

        WebElement goButton = driver.findElement(By.id("memberLoginDialogokButton"));
        goButton.click();

        Thread.sleep(3000);

        WebElement welcomeText = null;

        WebElement logOut = driver.findElement(By.xpath("//*[@id=\"comp-iiqg1vggactionTitle\"]"));
        logOut.click();
        System.out.println("Login Successful");

        try {
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test']"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(welcomeText != null);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private void dimissPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement popHTML = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("comp-jgmoxwr2inlineContent")));
        WebElement overlayDiv = driver.findElement(By.id("p7kjtbalatabgcoloroverlay"));
        overlayDiv.click();
    }
}
