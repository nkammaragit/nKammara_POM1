package stepDefinitions;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.util.ExtentManager;
import com.letzAutomate.qa.util.QuitAllBrowsers;
import com.letzAutomate.qa.util.TestUtil2;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentTest test;
	public static TestBase testbase= new TestBase();
	public static Scenario scenario;

	@Before
	public static void setUp(Scenario scenario) throws IOException {
		htmlReporter = new ExtentSparkReporter("target/extent-report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		String scenarioName = scenario.getName();
		String[] parts = scenario.getUri().toString().split("[\\\\/]");
		test = extent.createTest(parts[parts.length - 1], scenarioName);
		 ExtentManager.setExtentTest(test);
	}

	@After
	public static void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		QuitAllBrowsers.quitAllBrowsers();
		TestBase.driver.quit();
		//		TestRunner.extent.addTestRunnerOutput("ext TEST1  \r\n");
		extent.flush();
		test.log(Status.INFO, "Driver is quit & extent is flushed ");
		String newFileName = TestUtil2.renameFileWithTimestamp("target/extent-report.html");
		Desktop desktop = Desktop.getDesktop();
		File reportFile = new File(newFileName);
		try {
			desktop.open(reportFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}