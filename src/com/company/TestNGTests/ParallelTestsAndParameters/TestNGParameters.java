package ParallelTestsAndParameters;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
This class can only be run as a TestNG Suite because of the parameters it's expecting. Otherwise it will throw a
TestNGException.
 */
public class TestNGParameters {

    @BeforeClass
    @Parameters({"browser", "platform"})
    /*
    We need to define one argument in the method signature for each parameter we're reading from the xml file!!
     */
    public void setUp(String browser, String platform) {
        System.out.println("TestNG_Parameters -> Setup");
        System.out.println("1. Parameter value from xml file: " + browser);
        System.out.println("2. Parameter value from xml file: " + platform);
    }

    @Test
    @Parameters({"response"})
    /*
    If we need to pass a parameters that it's a not a String type, we need to cast it or manipulate this value with
    Java. In this case, we split it so we can treat it like an array.
     */
    public void testMethod1(String response) throws InterruptedException {
        String[] stringArray = response.split(",");
        System.out.println("TestNG_Parameters -> testMethod1");
        System.out.println("Response from xml file: " + response);
        System.out.println("stringArray[0] from xml file: " + stringArray[0]);
        System.out.println("stringArray[1] from xml file: " + stringArray[1]);
    }
}
