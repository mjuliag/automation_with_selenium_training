package seleniumgrid;

import com.company.automationframework.SearchPageFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestSuitBase {
    protected WebDriver driver;
    protected SearchPageFactory search;

    @Parameters({"platform", "browser", "version", "url"})
    @BeforeClass(alwaysRun = true)
    public void setup(String platform, String browser, String
            version, String url) throws MalformedURLException {
        driver = getDriverInstance(platform, browser, version, url);
        search = PageFactory.initElements(driver, SearchPageFactory.class);
    }

    /*I have no idea how this works. I did it using a Docker image with Chrome, not a virtual machine like the tutorial
    does.
    The platform setting commented code is from a previous version in which the tutorial uses DesireCapabilities class
    instead of Capabilities but I couldn't figure that out, I'm not sure if its needed or if its deprecated, but I
    kept getting a Remote WebDriver UnreachableBrowserException and Capabilities errors.
    The general idea of connecting to a remote web driver is the important stuff in this class.
    TODO remember to change the nodeURL
     */
    public static WebDriver getDriverInstance(String platform, String browser, String version, String url)
            throws MalformedURLException {
        String nodeURL = "http://localhost:4444/wd/hub";
        WebDriver driver = null;
        Capabilities caps = null;

        // Platforms
        /*
        if (platform.equalsIgnoreCase("Windows")) {
            caps.setPlatform(Platform.WINDOWS);
        }
        if (platform.equalsIgnoreCase("Linux")) {
            caps.setPlatform(Platform.LINUX);
        }
         */
        // Browsers
        if (browser.equalsIgnoreCase("chrome")) {
            caps = DesiredCapabilities.chrome();
        }
        if (browser.equalsIgnoreCase("firefox")) {
            caps = DesiredCapabilities.firefox();
        }
        // Version
        //caps.setVersion(version);
        driver = new RemoteWebDriver(new URL(nodeURL), caps);
        // Maximize the browser's window
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Open the Application
        driver.get(url);
        return driver;
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
