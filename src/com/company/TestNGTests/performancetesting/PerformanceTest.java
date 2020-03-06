package performancetesting;

import com.company.Constants;
import com.company.usefulmethods.ExcelUtility;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.company.automationframework.SearchPageFactory;

import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import java.lang.reflect.Method;

public class PerformanceTest {
    long startTime;
    long endTime;
    long duration;
    double seconds;

    private WebDriver driver;
    private String baseUrl;
    SearchPageFactory searchPage;
    private static Logger log = LogManager.getLogger(PerformanceTest.class);

    @BeforeClass
    public void beforeClass() throws Exception {
        Logger logFile = LogManager.getLogger("performancetest");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.com/";
        searchPage = new SearchPageFactory(driver);

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /* Tell the code about the location of Excel file. We use the Constants class for this and we change the
        location and name of the Excel file, since we already use this clase for the data driven test demo.
         */
        ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "Sheet1");
    }

    @Test
    //The java Method class allows us to get the name of the method so we can use it later
    public void searchFlight(Method name) throws Exception {
        startTime = System.nanoTime();
        driver.get(baseUrl);
        searchPage.clickFlightsTab();
        searchPage.setOriginCity("New York");
        searchPage.setDestinationCity("San Francisco");
        searchPage.setDepartureDate("10/28/2015");
        searchPage.setReturnDate("10/31/2015");
        endTime = System.nanoTime();
        duration = endTime - startTime;
        seconds = (double)duration / 1000000000.0;
        log.info("*****************************************");
        log.info("Time taken to execute this method: " + seconds + " seconds");
        /* When we create the excel file, we must create the rows and type "test case" and "time" or whatever in the
        row we are trying to write. If there is nothing in the row, the code will fail with a null pointer exception
         */
        ExcelUtility.setCellData(name.getName(), 0, 1);
        ExcelUtility.setCellData(seconds, 1, 1);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
