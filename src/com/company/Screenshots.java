package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

public class Screenshots {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.com/";
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

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    @After
    public void tearDown() throws Exception {
        String fileName = getRandomString(10) + ".jpg";
        String newDirectory = "C:\\Users\\JuliaGirona\\Desktop\\";

        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(newDirectory + fileName);
        
        Path path = Files.copy(sourceFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        if (Files.exists(path)) {
            System.out.println("File copied succesfully to " + destination);
        } else {
            System.out.println("Unable to copy file :(");
        }

        driver.quit();
    }
}

