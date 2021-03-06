package seleniumgrid;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SeleniumGridParallelTestFramework extends TestSuitBase {

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
    }

    @Test
    public void searchFlights() throws Exception {
        search.clickFlightsTab();
        search.setOriginCity("New York");
        search.setDestinationCity("San Francisco");
        search.setDepartureDate("10/28/2015");
        search.setReturnDate("10/31/2015");
    }

    @AfterClass
    public void tearDown() throws Exception {
    }
}
