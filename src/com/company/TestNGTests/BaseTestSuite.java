import org.testng.annotations.*;

public class BaseTestSuite {

    @BeforeClass
    public void beforeClass() {
        System.out.println("\nBaseTestSuite -> before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\nBaseTestSuite -> after class");
    }

    /*
    @BeforeTest and @AfterTest annotations are related to the <test> tags in the xml that has the test suite
    configuration. In this case it's the testng.xml file in the project. These methods are going to get executed before
    every test according to the xml file, not every test method in the test classes!
     */
    @BeforeTest
    public void beforeTest() {
        System.out.println("\nBaseTestSuite -> before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("\nBaseTestSuite -> after test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("\nBaseTestSuite -> before suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("\nBaseTestSuite -> after suite");
    }
}
