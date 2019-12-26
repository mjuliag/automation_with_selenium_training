package paralleltestsandparameters;

import org.testng.annotations.Test;

/*
This class should be run with the testng-parallel.xml test suite with TestNG for the demo. We shouldn't use this
feature if we have methods that are dependent with each other!
 */
public class TestNGParallel1 {
    @Test
    public void testMethod1() throws InterruptedException {
        System.out.println("TestNG_Parallel1 -> testMethod1");
        Thread.sleep(6000);
        System.out.println("TestNG_Parallel1 -> testMethod1 -> More Steps");
    }

    @Test
    public void testMethod2() throws InterruptedException {
        System.out.println("TestNG_Parallel1 -> testMethod2");
        Thread.sleep(6000);
        System.out.println("TestNG_Parallel1 -> testMethod2 -> More Steps");
    }
}
