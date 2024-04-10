package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src\\test\\resources\\features",monochrome=true,
glue="stepdefinitions",
plugin={"pretty",
		"junit:target\\JUnitReports\\report.xml",
		"json:target\\JSONReports\\report.json",
		"html:target\\HtmlReports",
},

tags="@SmokeTest")

public class TestRunner extends AbstractTestNGCucumberTests{

}
