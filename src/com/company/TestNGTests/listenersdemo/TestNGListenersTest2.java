package listenersdemo;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Remember to change the class in testng-listers.xml file in order to run this tests!!!

The @Listeners notation above the class has a lot of bugs associated with it. For example: when the suite contains more
than one test, then all the methods from the custom listeners are executed twice. Or maybe out of the blue, testNG won't
recognize the class in the @Listeners notation. Anyways, I found it much better to specify the listener in the xml file
with the <listeners> tag. I'll leave the notation commented out just for reference.
 */

//@Listeners(CustomListenerWithTests.class)
public class TestNGListenersTest2 {

    @BeforeClass
    public void setUp() {
        System.out.println("Code in before class");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("Code in after class");
    }

    @Test
    public void testMethod1() {
        System.out.println("Code in testMethod1");
        Assert.assertTrue(true);
    }

    @Test
    public void testMethod2() {
        System.out.println("Code in testMethod2");
        Assert.assertTrue(false);
    }
}
