package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NavigatingBetweenPages {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseUrl);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        String loginUrl = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";

        driver.navigate().to(loginUrl);
        Thread.sleep(2000);
        String currentLoginUrl = driver.getCurrentUrl();
        System.out.println(currentLoginUrl);

        driver.navigate().back();
        Thread.sleep(2000);
        String backToHome = driver.getCurrentUrl();
        System.out.println(backToHome);

        driver.navigate().forward();
        Thread.sleep(2000);
        String backToLogin = driver.getCurrentUrl();
        System.out.println(backToLogin);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().refresh();
        System.out.println("Refreshed page!");
        Thread.sleep(2000);

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
