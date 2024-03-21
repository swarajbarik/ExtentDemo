package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private static ExtentReports extentReports;
    private static ExtentTest test;

    @Before
    public void beforeScenario(Scenario scenario) {
        if (extentReports == null) {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
        }
        test = extentReports.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            // Log additional details like screenshots, error messages, etc.
            test.fail("Details of the failure");
        } else {
            test.pass("Scenario passed");
        }
        extentReports.flush();
    }

    public static ExtentTest getTest() {
			return test;
    }
}
