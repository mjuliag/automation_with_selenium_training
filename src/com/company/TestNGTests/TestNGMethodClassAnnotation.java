import org.testng.annotations.*;

public class TestNGMethodClassAnnotation {

    @BeforeClass
    public void setUp() {
        System.out.println("\nThis runs once before class");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("\nThis runs once after class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\nThis runs before every method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\nThis runs after every method");
    }

    @Test
    public void testMethod1() {
        System.out.println("\nRunning Test -> testMethod1");
    }

    @Test
    public void testMethod2() {
        System.out.println("\nRunning Test -> testMethod2");
    }
}
