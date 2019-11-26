import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestNGEnableTimeout {

    @BeforeClass
    public void setUp() {
        System.out.println("before class");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("after class");
    }

    /*
    Disabling TCs homes handy when we have a failing test but we already know the bug and we don't want nuisance in the
    report.
    */
    @Test(enabled = false)
    public void testMethod1() {
        System.out.println("testMethod1");
    }

    /*
    Basically the test fails after the timeout.
     */
    @Test(timeOut = 100)
    public void testMethod2() throws InterruptedException {
        System.out.println("testMethod2");
        Thread.sleep(200);
    }
}
