package testrun;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",
				 glue="stepdef",
				 plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
				//tags="@functional"
				)
				 

public class testrunner extends AbstractTestNGCucumberTests
{
       
}
