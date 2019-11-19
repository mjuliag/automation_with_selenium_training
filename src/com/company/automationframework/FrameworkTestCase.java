package com.company.automationframework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FrameworkTestCase {
    private WebDriver driver;
    private String baseUrl;
    SearchPageFactory searchPage;

    @Before
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.com/";

        searchPage = new SearchPageFactory(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws Exception {
        searchPage.clickFlightsTab();
        searchPage.setOriginCity("New York");
        searchPage.setDestinationCity("San Francisco");
        searchPage.setDepartureDate("10/28/2015");
        searchPage.setReturnDate("10/31/2015");
    }

    @After
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
