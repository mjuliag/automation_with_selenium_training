package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import com.company.usefulmethods.GenericMethods;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Screenshots {
    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.com/";
        gm = new GenericMethods(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testScreenshots() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("tab-flight-tab-hp")).click();

        // Find Elements
        WebElement flight_origin = driver.findElement(By.id("flight-origin-hp-flight"));
        WebElement flight_destination = driver.findElement(By.id("flight-destination-hp-flight"));
        WebElement departure_date = driver.findElement(By.id("flight-departing-hp-flight"));
        WebElement return_date = driver.findElement(By.id("flight-returning-hp-flight"));
        WebElement search = driver.findElement(By.xpath("//*[@id=\"gcw-flights-form-hp-flight\"]/div[7]/label/button"));

        // Send data to elements
        flight_origin.sendKeys("New York");
        departure_date.sendKeys("09/11/2019");
        return_date.clear();
        return_date.sendKeys("09/11/2019");
        flight_destination.sendKeys("New York");
        search.click();
    }

    @After
    public void tearDown() throws IOException {
        gm.takeScreenshot();
        driver.quit();
    }


}

