package com.company.usefulmethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementListDemo {

    private WebDriver driver;
    private String baseUrl;
    private GenericMethodsPreRefactor gm;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        gm = new GenericMethodsPreRefactor(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testMethod() throws Exception {
        driver.get(baseUrl);

        //The xpath used returns two elements!
        List<WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");

        int size = elementList.size();
        System.out.println("Size of the element list is: " + size);

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        //driver.quit();
    }
}

