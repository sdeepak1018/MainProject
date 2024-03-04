package test_Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features = {".//FeatureFile/CarLoan.feature"},
					glue="step_defenition",
					plugin = {"pretty", "html:reports/CucumberSmokeReports.html"},
					tags = "@SmokeTesting"
		)

public class testRunnerSmoke {
	
	

}
