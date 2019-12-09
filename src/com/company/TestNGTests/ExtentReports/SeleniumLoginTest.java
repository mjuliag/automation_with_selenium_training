package ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        baseUrl = "http://www.letskodeit.com/";
        //Remember to change the filePath in which the html report file is going to be saved!!!!
        report = new ExtentReports("C:\\Users\\JuliaGirona\\Desktop\\logintest.html");
        test = report.startTest("Verify Welcome Text");
        driver = new ChromeDriver();
        test.log(LogStatus.INFO, "Browser Started...");

        // Maximize the browser's window
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser Maximized");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(LogStatus.INFO, "Web application opened");
        dimissPopUp();
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
        signupLink.click();
        test.log(LogStatus.INFO, "Clicked on signup link");

        WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        loginLink.click();
        test.log(LogStatus.INFO, "Clicked on login link");

        WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
        emailField.sendKeys("test@email.com");
        test.log(LogStatus.INFO, "Enter email");

        WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
        passwordField.sendKeys("abcabc");
        test.log(LogStatus.INFO, "Enter password");

        WebElement goButton = driver.findElement(By.id("memberLoginDialogokButton"));
        goButton.click();
        test.log(LogStatus.INFO, "Clicked Go button");

        Thread.sleep(3000);

        WebElement welcomeText = null;

        try {
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test']"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(welcomeText != null);
        test.log(LogStatus.PASS, "Verified Welcome Text");
    }

    private void dimissPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement popHTML = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("comp-jgmoxwr2inlineContent")));
        WebElement overlayDiv = driver.findElement(By.id("p7kjtbalatabgcoloroverlay"));
        overlayDiv.click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}
