package com.company.interviewquestions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*This is another possible scenario for the StaleElementException! We already had this class in the project, I'm just
reusing it here for organization purposes.
 */
public class Autocomplete {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.supershuttle.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testAutocomplete() throws Exception {
        driver.get(baseUrl);
        String searchingText = "Albuquerque, NM, USA";
        String partialText = "Albuquerque";

        WebElement text = driver.findElement(By.id("txtPickupLocation"));
        Thread.sleep(2000);
        text.sendKeys(partialText);

        WebElement element = driver.findElement(By.id("txtPickupLocationautocomplete-list"));
        List<WebElement> results = element.findElements(By.tagName("span"));
        int size = results.size();

        System.out.println("The size of the list is: " + size);

        for (int i = 0; i < size; i++) {
            System.out.println(results.get(i).getText());
        }

        Thread.sleep(2000);
        for (WebElement result : results) {
            if (result.getText().equals(searchingText)) {
                System.out.println("Select " + result.getText());
                result.click();
                /* We can also trigger the exception by moving the printing statement after the click like this
                System.out.println("Select " + result.getText());
                This would cause the exception because it will try to find the text of an element that has gone stale
                 */
                System.out.println(searchingText + " was selected!");
                /*We can trigger the StaleElementException by removing this break statement! If we don't break out of
                the loop we are still going through the list of elements and since we already clicked it, the list of
                elements is gone, is not visible for us on the website. What happens is: if the list is gone, and the
                loop is still going is goig to try to access the next element, but the element doesn't exist there, the
                element has become STALE!
                 */
                //break;
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        //driver.quit();
    }
}
