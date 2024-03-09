package stepDefinitions;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src\\test\\resources\\Features",monochrome=true,
glue="stepDefinitions",
plugin={"pretty",
		"junit:target\\JUnitReports\\report.xml",
		"json:target\\JSONReports\\report.json",
		"html:target\\HtmlReports",
},

tags="@SmokeTest")

public class TestRunner extends AbstractTestNGCucumberTests{

//	TestNG testng = new TestNG();
//    List<String> suites = new ArrayList<>();
//    suites.add("testng.xml"); // Path to your testng.xml file
//    testng.setTestSuites(suites);
//    testng.run();
}
