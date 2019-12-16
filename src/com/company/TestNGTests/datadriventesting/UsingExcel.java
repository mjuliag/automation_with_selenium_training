package datadriventesting;

import com.company.Constants;
import com.company.usefulmethods.ExcelUtility;
import com.company.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//Mental note: it's possible to do this with a Google Sheets .xlsx file :) ExcelDataGS.xlsx is a Google sheet.
public class UsingExcel {
    private WebDriver driver;
    private HomePage hp;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.URL);
        hp = new HomePage(driver);
        hp.dismissPopUp();
        driver.findElement(By.xpath("//span[text()='Learn Now']")).click();
        // Click login button
        driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]")).click();
        Thread.sleep(2000);
        // Tell the code about the location of Excel file
        ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTests");
    }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {
        Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
        return testData;
    }

    @Test(dataProvider = "loginData")
    public void testUsingExcel(String username, String password) throws Exception {
        // Enter username
        driver.findElement(By.id("user_email")).sendKeys(username);
        // Enter password
        driver.findElement(By.id("user_password")).sendKeys(password);
        // Click Login button
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.id("user_email")).clear();
        Thread.sleep(2000);

        // Find if error messages exist
        boolean result = driver.findElements(By.xpath("//div[contains(text(),'Invalid email or password')]")).size() != 0;
        Assert.assertTrue(result);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
