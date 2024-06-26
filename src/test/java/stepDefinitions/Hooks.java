package stepdefinitions;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.pages.LoginPage;
import com.letzAutomate.qa.util.CommonUtils;
import com.letzAutomate.qa.util.ExtentManager;
import com.letzAutomate.qa.util.SeleniumUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends TestBase {

	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentTest test;
//	public static TestBase testbase= new TestBase();
	public static Scenario scenario;
	public static WebDriver driver;

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
	public static void tearDown(Scenario scenario) throws InterruptedException {
		if (scenario != null && scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			SeleniumUtils.captureScreenshot(driver, screenshotName);
		}
//		QuitAllBrowsers.quitAllBrowsers();
		SeleniumUtils.quitAllBrowsers();
		 if (driver != null) driver.quit();
		//		TestRunner.extent.addTestRunnerOutput("ext TEST1  \r\n");
		test.log(Status.INFO, "Driver is quit & extent is flushed ");
		extent.flush();
		
		String newFileName = CommonUtils.renameFileWithTimestamp("target/extent-report.html");
		Desktop desktop = Desktop.getDesktop();
		File reportFile = new File(newFileName);
		try {
			desktop.open(reportFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
