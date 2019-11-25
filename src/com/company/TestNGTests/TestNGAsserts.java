import com.company.testngdemocode.DemoCodeForTesting;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
For IntelliJ to import the TestNG library we need to mark the directory in which the tests are as a Test Source Folder
in the File > Project Structure menu or it won't find the library. In the same menu but in the dependencies tab, we
need to set the scope of TestNG to compile, if it's in test (which it is by default) the compiler won't find the
org.testng.annotations package.
 */
public class TestNGAsserts {

    @Test
    public void testSum() {
        System.out.println("\nRunning Test -> testSum");
        DemoCodeForTesting obj = new DemoCodeForTesting();
        int result = obj.sumNumbers(1, 2);
        Assert.assertEquals(result, 3);
    }

    @Test
    public void testStrings() {
        System.out.println("\nRunning Test -> testStrings");
        String expectedString = "Hello World";
        DemoCodeForTesting obj = new DemoCodeForTesting();
        String result = obj.addStrings("Hello", "World");
        Assert.assertEquals(result, expectedString);
    }

    @Test
    public void testArrays() {
        System.out.println("\nRunning Test -> testArrays");
        int[] expectedArray = {1, 2, 3, 4};
        DemoCodeForTesting obj = new DemoCodeForTesting();
        int[] result = obj.getArray();
        Assert.assertEquals(result, expectedArray);
        System.out.println("\nEnd Test -> testArrays");
    }
}