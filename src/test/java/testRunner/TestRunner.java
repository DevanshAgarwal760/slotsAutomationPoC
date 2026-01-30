package testRunner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import Utilities.ScenarioWatchdog;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(
    features = "src/test/java/features", // Path to .feature files
    glue = {"stepDefinitions","hooks","commonTestMethods"},       // Packages containing step definitions and hooks
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json",
        "rerun:target/rerun.txt"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Test(dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        String scenarioName = pickleWrapper.getPickle().getName();

        ScenarioWatchdog.runWithTimeout(scenarioName, () -> {
            super.runScenario(pickleWrapper, featureWrapper);
        });
    }
	@AfterSuite(alwaysRun = true)
    public void shutdownWatchdog() {
        ScenarioWatchdog.shutdown();
    }
}
