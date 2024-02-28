package stepDefinitions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src\\test\\resources\\Features",monochrome=true,
//glue="stepDefinitions",

plugin={"pretty",
		"junit:target\\JUnitReports\\report.xml",
		"json:target\\JSONReports\\report.json",
		"html:target\\HtmlReports",
},

tags="@SmokeTest")

public class TestRunner extends AbstractTestNGCucumberTests{

}
