package stepDefinitions;
import java.io.File;
import java.io.IOException;
import java.awt.Desktop;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.gherkin.model.Feature;
//import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.util.QuitAllBrowsers;
import com.letzAutomate.qa.util.TestUtil2;

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
