package com.company.saucelabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

//I used a free trial for this demo with a work email account that expires in 15 days.
public class SauceLabsDemo {

    public static final String USERNAME = "juliagirona";
    //We get the Access Key in the user settings of the Sauce Labs site
    public static final String ACCESS_KEY = "";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "80.0");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        driver.get("https://www.google.com");
        System.out.println("title of page is: " + driver.getTitle());

        Thread.sleep(3000);

        driver.quit();
    }
}
