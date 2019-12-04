package PreserveOrderOfTestsDemo;

import org.testng.annotations.Test;

/*
The preserve-order tag in the testng-preserve-enable.xml file determines if the tests go by the order in which they are
in the xml file or de default alphabetical order. If the tag it's set to true, then the tests are going to run in
whatever order they are in the xml file. If it's set to false, they are going to run alphabetically.
 */
public class TestNGPreserve1 {
    @Test
    public void testMethod1() {
        System.out.println("TestNG_Preserve1 -> testMethod1");
    }

    @Test
    public void testMethod2() {
        System.out.println("TestNG_Preserve1 -> testMethod2");
    }
}
