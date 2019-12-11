package ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

/*
Technically not all the elements are in the Home Page, except the Sign Up link, the rest should be in a LoginPage page
object class, but for keeping this demo more simple, I kept them all in this page object class.
 */
public class HomePage {

    ExtentTest test;
    WebDriver driver = null;

    public HomePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    public void clickSignUpLink() {
        WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
        signupLink.click();
        test.log(LogStatus.INFO, "Clicked on signup link");
    }

    public void clickLoginLink() {
        WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        loginLink.click();
        test.log(LogStatus.INFO, "Clicked on login link");
    }

    public void completeEmailField(String email) {
        WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
        emailField.sendKeys(email);
        test.log(LogStatus.INFO, "Enter email");
    }

    public void completePasswordField(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
        passwordField.sendKeys(password);
        test.log(LogStatus.INFO, "Enter password");
    }

    public void clickGoButton() {
        WebElement goButton = driver.findElement(By.id("memberLoginDialogokButton"));
        goButton.click();
        test.log(LogStatus.INFO, "Clicked Go button");
    }

    public boolean isWelcomeTextPresent() {
        WebElement welcomeText = null;
        try {
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test']"));
            if (welcomeText != null) {
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public void login(String email, String password) {
        clickSignUpLink();
        clickLoginLink();
        completeEmailField(email);
        completePasswordField(password);
        clickGoButton();
    }

    public void dismissPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement popHTML = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("comp-jgmoxwr2inlineContent")));
        WebElement overlayDiv = driver.findElement(By.id("p7kjtbalatabgcoloroverlay"));
        overlayDiv.click();
    }
}
