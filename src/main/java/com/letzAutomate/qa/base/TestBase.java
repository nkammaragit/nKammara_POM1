package com.letzAutomate.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.TimeoutException;
//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.letzAutomate.qa.pages.HomePage;
import com.letzAutomate.qa.pages.LoginPage;
//import com.letzAutomate.qa.util.Log4jConfig;
import com.letzAutomate.qa.util.StaticVariables;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public final static org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestBase.class);
	//================
	public static HomePage homePage;
	public static LoginPage loginPage;
	//================

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
			prop.load(ip);
		} catch (IOException  io) {
			io.printStackTrace();
		} 
	}

	public static void initialization(){
		try {
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe") ;
				driver = new ChromeDriver(); 
				logger.info("****** TestBase initialization (Chrome driver set up done) ********");
			}
			else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver");	
				driver = new FirefoxDriver(); 
				logger.info("****** TestBase initialization (Firefox driver set up done) ********");
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(StaticVariables.PAGELOAD_TIMEOUT));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(StaticVariables.PAGELOAD_TIMEOUT));
			wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			driver.get(prop.getProperty("urlOrange"));
//			driver.get(prop.getProperty("urlGuru"));
			logger.info("****** TestBase initialization (URL launched ) ********");
			//		 =======================
			homePage = new HomePage();
			loginPage = new LoginPage();
			//=================
		}
		catch(TimeoutException te){
			//			Hooks.test.log(Status.FAIL, "Home page not appeared - Login Failed");
			logger.error("****** TestBase Initialization Failed ********");
			te.printStackTrace();
		}
	}}