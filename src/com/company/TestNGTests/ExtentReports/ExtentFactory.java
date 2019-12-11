package ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

    public static ExtentReports getInstance() {
        ExtentReports extent;
        String Path = "C:\\Users\\JuliaGirona\\Desktop\\logintest.html";
        // the false it's for appending the different test cases to the same report
        extent = new ExtentReports(Path, false);
        extent
                .addSystemInfo("Selenium Version", "3.0 maybe")
                .addSystemInfo("Platform", "Windows");

        return extent;
    }
}
