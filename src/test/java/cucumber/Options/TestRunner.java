package cucumber.Options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// If there are multiple feature files then we can pass feature path as src/test/java/features/FeatureFileName

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features", 
		plugin = "json:target/jsonReports/cucumber-reports.json",
		glue = {"stepdefination"},
		monochrome = true,
		tags = {"@AddPlace"}  )

public class TestRunner {

	// To run Test Cases through Maven using Tags
	// Cmd: mvn test -Dcucumber.options="--tags @TagName"

}
