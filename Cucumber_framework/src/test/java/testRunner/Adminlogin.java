package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(dryRun = false,
features = {"./Featurefiles/Adminlogin.feature","./Featurefiles/AddingEmploye.feature"},
glue = {"stepDefination"},
monochrome = false,
tags=("@Validdata ,@MultipleData not,@Addemp"), // when ever we are adding not means that senario will skipked 
plugin = {"pretty","html:target/report/cucumber",
		"junit:target/report/cucumber.xml","json:target/report/cucumber.json"}

)

@RunWith(Cucumber.class)
public class Adminlogin extends AbstractTestNGCucumberTests{
	

}
