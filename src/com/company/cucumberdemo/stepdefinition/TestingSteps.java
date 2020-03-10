package com.company.cucumberdemo.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestingSteps {
    private WebDriver driver;
    private String baseUrl;
    WebElement welcomeText = null;

    @Given("^User is on the home page$")
    public void user_is_on_the_home_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        baseUrl = "http://www.letskodeit.com/";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        dimissPopUp();
    }

    @When("^User enters username and password$")
    public void user_enters_username_and_password() {
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
    }

    @Then("^A welcome text is displayed$")
    public void a_welcome_text_is_displayed() {
        try {
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test']"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(welcomeText != null);
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
