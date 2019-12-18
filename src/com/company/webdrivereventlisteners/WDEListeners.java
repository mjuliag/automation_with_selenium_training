package com.company.webdrivereventlisteners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WDEListeners {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        String baseUrl = "https://www.expedia.com/";
        WebDriver driver = new ChromeDriver();

        EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);

        //We register the eDriver to the HandleEvents so it knows how to perform according to each action
        HandleEvents he = new HandleEvents();
        eDriver.register(he);

        //We perform all the actions using the EventFiringWebDriver instead.
        eDriver.get(baseUrl);
        eDriver.findElement(By.id("tab-flight-tab-hp")).click();

        eDriver.quit();
    }
}
