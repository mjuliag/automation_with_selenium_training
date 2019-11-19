package com.company.findlinks;

import com.company.automationframework.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//TODO find out how to fix the "Too many requests" response
public class FindLinks {
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
    public void testFindLinks() {
        driver.get(baseUrl);
        SearchPage.navigateToFlightsTab(driver);

        List<WebElement> linksList = clickableLinks(driver);
        for (WebElement link : linksList) {
            String href = link.getAttribute("href");
            try {
                //We pass the href as an URL!
                System.out.println("URL " + href + " returned " + linkStatus(new URL(href)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static List<WebElement> clickableLinks(WebDriver driver) {
        List<WebElement> linksToClick = new ArrayList<>();
        //We find all elements with tag a which are going to be links
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        //Then we add all the elements that are images, since they're also links
        elements.addAll(driver.findElements(By.tagName("img")));

        //If the href attribute is not null, it means that the link is clickable
        for (WebElement e : elements) {
            if (e.getAttribute("href") != null) {
                linksToClick.add(e);
            }
        }
        return linksToClick;
    }

    public static String linkStatus(URL url) {
        /* We can refer to this link for the code in this methos:
        http://download.java.net/jdk7/archive/b123/docs/api/java/net/HttpURLConnection.html#getResponseMessage%28%29
         */
        try {
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.connect();
            String responseMessage = http.getResponseMessage();
            http.disconnect();
            return responseMessage;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
