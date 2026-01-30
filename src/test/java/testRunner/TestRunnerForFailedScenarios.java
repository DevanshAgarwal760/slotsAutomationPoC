package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@target/rerun.txt", // Path to failed scenarios
	    glue = {"stepDefinitions","hooks","commonTestMethods"},       // Packages containing step definitions and hooks
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports_forFailedScenarios.html",
	        "json:target/cucumber.json",
	        "rerun:target/rerunSecond.txt"
	    },
	    monochrome = true
	    
	)
	public class TestRunnerForFailedScenarios extends AbstractTestNGCucumberTests {
	    // No need to override anything unless customizing test execution
		/*@Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }*/
	}