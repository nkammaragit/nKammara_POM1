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

//import com.letzAutomate.qa.util.Log4jConfig;
import com.letzAutomate.qa.util.StaticVariables;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
//	 public final static Logger logger = Logger.getLogger(TestBase.class);
	 public final static org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestBase.class);
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		try {
		   
		    
		    logger.info("logger info **************");
		    logger.warn("logger warn **************");
		    logger.error("logger error **************");
		
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe") ;
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver");	
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(StaticVariables.PAGELOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(StaticVariables.PAGELOAD_TIMEOUT));
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.get(prop.getProperty("url2"));
	}
		catch(TimeoutException te){
//			Hooks.test.log(Status.FAIL, "Home page not appeared - Login Failed");
			te.printStackTrace();
	}
}}