package testRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
//		tags= "@regression",
		
		features = {".//FeatureFiles/"},
		glue = "stepDefinations",
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"pretty","html:target/htmlreport.html"}
		)

public class TestRun extends AbstractTestNGCucumberTests{

}
