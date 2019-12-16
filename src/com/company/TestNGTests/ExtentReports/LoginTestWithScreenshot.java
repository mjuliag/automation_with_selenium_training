package ExtentReports;

import com.company.HomePage;
import com.company.usefulmethods.GenericMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTestWithScreenshot {
    private WebDriver driver;
    private String baseUrl;
    private ExtentReports report;
    private ExtentTest test;
    private GenericMethods gm;
    private HomePage hp;

    @BeforeClass
    public void beforeClass() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        baseUrl = "http://www.letskodeit.com/";
        gm = new GenericMethods(driver);
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
        hp = new HomePage(driver, test);
        hp.dismissPopUp();
    }

    //TODO !!!
    /*
    In order to make this test fail and take a screenshot we need to change some value in the ExtentReports.HomePage class, for
    example, changing the welcome text in the isWelcomeTextPresent() method.
     */
    @Test
    public void test1_validLoginTest() throws Exception {
        hp.login("test@email.com", "abcabc");

        Thread.sleep(3000);

        boolean result = hp.isWelcomeTextPresent();

        Assert.assertTrue(result);
        test.log(LogStatus.PASS, "Verified Welcome Text");
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String path = gm.takeScreenshot(driver, testResult.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
        }
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}
