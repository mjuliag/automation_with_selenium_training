import com.company.testngdemocode.DemoCode;
import org.testng.annotations.Test;

/*
For IntelliJ to import the TestNG library we need to mark the directory in which the tests are as a Test Source Folder
in the File > Project Structure menu or it won't find the library. In the same menu, but in the dependencies tab we
need to set the scope of TestNG to compile, if it's in test (which it is by default) the compiler won't find the
org.testng.annotations package.
 */
public class TestDemoTest {

    @Test
    public void testMethod1() {
        DemoCode obj = new DemoCode();
        int result = obj.sumNumber(1, 2);
        System.out.println("Running Test -> testMethod1");
    }

    @Test
    public void testMethod2() {
        System.out.println("Running Test -> testMethod2");
    }

    @Test
    public void testMethod3() {
        System.out.println("Running Test -> testMethod3");
    }
}