import com.company.testngdemocode.DemoCodeForTesting;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


//SoftAssert becomes helpful to run everything at once and the execution doesn't stop when an assertion fails.
public class TestNGSoftAsserts {

    @Test
    public void testSum() {
        SoftAssert sa = new SoftAssert();
        System.out.println("\nRunning Test -> testSum");
        DemoCodeForTesting obj = new DemoCodeForTesting();
        int result = obj.sumNumbers(1, 2);
        sa.assertEquals(result, 2);
        System.out.println("\nLine after assert 1");
        sa.assertEquals(result, 3);
        System.out.println("\nLine after assert 2");
        //This method fails the test if an assert fails
        sa.assertAll();
    }
}
