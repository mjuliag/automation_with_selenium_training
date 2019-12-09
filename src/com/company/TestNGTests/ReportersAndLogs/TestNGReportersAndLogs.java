package ReportersAndLogs;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

/*
The Reporter is like a replacement of Log4j or Log4j2 of TestNG for creating reports and logs in console or in
external files also. It's also a good a idea to mix them up and use Log4j for individual actions and Reporter for high
level actions like "Test started", "Test finished".
To generate the report we have to create an xml file for a TestNG suite and run the TestNG suite.
To generate the test-output file with the reports in IntelliJ, we need to go to Edit Configurations > Go to the
Listeners tab of the suite > Click in the "Use default reporters" checkbox.
 */
public class TestNGReportersAndLogs {
    @BeforeClass
    public void setUp() {
        Reporter.log("TestNG_ReportsAndLogs -> This runs once before class", true);
    }

    @AfterClass
    public void cleanUp() {
        Reporter.log("TestNG_ReportsAndLogs -> This runs once after class", true);
    }

    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("TestNG_ReportsAndLogs -> This runs before every method", true);
    }

    @AfterMethod
    public void afterMethod() {
        Reporter.log("TestNG_ReportsAndLogs -> This runs after every method", true);
    }

    @Test
    public void testMethod1() {
        Reporter.log("TestNG_ReportsAndLogs -> testMethod1", true);
    }

    @Test
    public void testMethod2() {
        Reporter.log("TestNG_ReportsAndLogs -> testMethod2", true);
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods={ "testMethod2" })
    public void testMethod3() {
        Reporter.log("TestNG_ReportsAndLogs -> testMethod3", true);
    }
}
