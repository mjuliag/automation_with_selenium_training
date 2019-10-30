package com.company.usefulmethods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IsElementPresentDemo {
    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        gm = new GenericMethods(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testMethod() throws Exception {
        driver.get(baseUrl);

        boolean result1 = gm.isElementPresent("name", "id");
        System.out.println("Is Element Present: " + result1);

        boolean result2 = gm.isElementPresent("name-not-present", "id");
        System.out.println("Is Element Present: " + result2);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
