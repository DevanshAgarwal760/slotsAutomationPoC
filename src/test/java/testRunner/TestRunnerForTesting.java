package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/onlyForTesting_features/Test.feature", // Path to .feature files
    glue = {"stepDefinitions","hooks","commonTestMethods"},       // Packages containing step definitions and hooks
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "rerun:target/rerun.txt"
    },
    monochrome = true
    
)
public class TestRunnerForTesting extends AbstractTestNGCucumberTests {
    // No need to override anything unless customizing test execution
	/*@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/
}
