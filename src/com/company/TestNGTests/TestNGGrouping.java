import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Not sure why I didn't need an xml file like all the tutorials say. I just needed to go to Edit Configurations, select
the group radio button and specify the name. If I want to run the testnggroups.xml file I need to do it as a suite.
 */
public class TestNGGrouping {

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @Test(groups = {"cars", "suv"})
    public void testBMWX6() {
        System.out.println("Running Test - BMW X6");
    }

    @Test(groups = {"cars", "sedan"})
    public void testAudiA6() {
        System.out.println("Running Test - Audi A6 ");
    }

    @Test(groups = {"bikes"})
    public void testNinja() {
        System.out.println("Running Test - Kawasaki Ninja");
    }

    @Test(groups = {"bikes"})
    public void testHondaCBR() {
        System.out.println("Running Test - Honda CBR");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("After Class");
    }
}
