package com.company.switchto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/*By default Selenium keeps focus in the current window. If we need to interact with an element that's in a new
window we need to tell Selenium to do the switch.
 */
public class SwitchWindow {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/pages/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {

      /*This is the code that won't work because it will search the searchbox in the current window. We will use this
        code later when we switch windows.
		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("python");
        */

        // Get the handle. The handle is an ID provided for the browser. Every new window has an unique handle.
        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent Handle: " + parentHandle);

        // Find Open Window button
        WebElement openWindow = driver.findElement(By.id("openwindow"));
        openWindow.click();

        /* Get all handles. When more than one window is open, we have the handles for all of them if we use
        getWindowHandles() We can save them in a List also but Set stores unique things. Set doesn't allow
        duplicates!
         */
        Set<String> handles = driver.getWindowHandles();

        // Switching between handles
        for (String handle : handles) {
            System.out.println(handle);
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                WebElement searchBox = driver.findElement(By.id("search-courses"));
                searchBox.sendKeys("python");
                Thread.sleep(2000);
                //This closes only the current focused window! quit() closes all windows!
                driver.close();
                break;
            }
        }

        // Switch back to the parent window
        driver.switchTo().window(parentHandle);
        driver.findElement(By.id("name")).sendKeys("test succesful");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
