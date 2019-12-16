package ExtentReports;

import com.company.ExtentFactory;
import com.company.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestUsingExtentFactoryClass1 {
    private WebDriver driver;
    private String baseUrl;
    private ExtentReports report;
    private ExtentTest test;
    private HomePage hp;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        baseUrl = "http://www.letskodeit.com/";
        //We initialize the report using the com.company.ExtentFactory class
        report = ExtentFactory.getInstance();
        test = report.startTest("Verify Welcome Text");
        driver = new ChromeDriver();
        hp = new HomePage(driver, test);
        test.log(LogStatus.INFO, "Browser Started...");

        // Maximize the browser's window
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser Maximized");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(LogStatus.INFO, "Web application opened");
        hp.dismissPopUp();
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        hp.login("test@email.com", "abcabc");

        Thread.sleep(3000);

        boolean result = hp.isWelcomeTextPresent();

        Assert.assertTrue(result);
        test.log(LogStatus.PASS, "Verified Welcome Text");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}
