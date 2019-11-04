package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarSelection {
    private WebDriver driver;
    private String baseUrl;

    LocalDate localDate = LocalDate.now();
    String currentDate = localDate.format(DateTimeFormatter.ofPattern("d"));

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.expedia.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        driver.get(baseUrl);
        // Click flights tab
        driver.findElement(By.id("tab-flight-tab-hp")).click();
        // Find departing field
        WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
        // Click departing field
        departingField.click();
        Thread.sleep(3000);
        // Find the date to be selected
        WebElement dateToSelect = driver.findElement(By.xpath("//div[@class=\"datepicker-cal-month\"][position()=1]//button[@data-day=\"30\"]"));
        // Click the date
        dateToSelect.click();
    }

    @Test
    public void testWithCurrentDates() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("tab-flight-tab-hp")).click();
        WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
        departingField.click();
        Thread.sleep(3000);
        WebElement calMonth = driver.findElement(By.xpath("//div[@class=\"datepicker-cal-month\"][position()=1]"));

        List<WebElement> allEnabledDates = calMonth.findElements(By.xpath("//div[@class=\"datepicker-cal-month\"][position()=1]//button[@class=\"datepicker-cal-date\"]"));


        //Not using this list but I think the Xpath might be useful for future reference
        //List<WebElement> allDisabledDates = calMonth.findElements(By.xpath("//div[@class=\"datepicker-cal-month\"][position()=1]//button[contains(@class, \"disabled\")]"));
        for (WebElement date : allEnabledDates) {
            if (date.getAttribute("data-day").equals(currentDate)) {
                date.click();
                System.out.println("Date was clicked!");
                break;
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}