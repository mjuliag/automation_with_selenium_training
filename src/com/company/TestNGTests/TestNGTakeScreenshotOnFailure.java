import com.company.usefulmethods.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
We already have an example of taking a screenshot if a test fails in the LoginTestWithScreenshot class
 */
public class TestNGTakeScreenshotOnFailure {
    WebDriver driver;
    String baseURL;

    @BeforeMethod
    public void setUp() {
        baseURL = "https://www.facebook.com";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("test");
        driver.findElement(By.id("pass")).sendKeys("test");
        driver.findElement(By.id("Loginbutton")).click();

    }

    @AfterMethod
    public void cleanUp(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed: " + testResult.getMethod().getMethodName());
            GenericMethods.takeScreenshot(driver, testResult.getName());
        }
        driver.quit();
    }

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}
