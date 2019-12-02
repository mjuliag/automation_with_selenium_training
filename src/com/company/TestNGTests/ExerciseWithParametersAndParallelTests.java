
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExerciseWithParametersAndParallelTests {

    WebDriver driver;
    String baseUrl;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        baseUrl = "https://letskodeit.teachable.com";
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    "C:\\Users\\JuliaGirona\\geckodriver-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[@id=\"navbar\"]//a[@href=\"/sign_in\"]")).click();
        System.out.println("Clicked on login!");
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("test@test.com");
        System.out.println("Writing some email...");
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("lalala");
        System.out.println("Writing some password...");
        driver.findElement(By.id("user_email")).clear();
        System.out.println("Clearing email field");
        driver.findElement(By.id("user_password")).clear();
        System.out.println("Clearing password field");
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}