package com.company.usefulmethods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GenericMethodDemo {

    private WebDriver driver;
    private String baseUrl;
    private GenericMethodsPreRefactor genericMethods;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        genericMethods = new GenericMethodsPreRefactor(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testMethod() throws Exception {
        driver.get(baseUrl);

        WebElement element = genericMethods.getElement("name", "id");
        element.sendKeys("test");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
