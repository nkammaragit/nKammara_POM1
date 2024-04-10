package com.letzAutomate.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.pages.HomePage;
import com.letzAutomate.qa.pages.LoginPage;
import com.letzAutomate.qa.util.CommonUtils;
import com.letzAutomate.qa.util.ExtentManager;
import com.letzAutomate.qa.util.SeleniumUtils;
import com.letzAutomate.qa.util.Constants;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait wait;
    public static org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestBase.class);
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static ExtentTest test;

    // Constants for file paths
    public static final String CONFIG_FILE_PATH = "/config/config.properties";
    public static final String DRIVER_FOLDER_PATH = "/drivers/";
    public static final String TEST_RESOURCES="/src/test/resources";

    public TestBase() {
        prop = CommonUtils.loadProperties(CONFIG_FILE_PATH);
    }

    public static void initialization() {
        try {
            test = ExtentManager.getExtentTest();
            String browserName = prop.getProperty("browser");
            SeleniumUtils.initializeWebDriver(browserName);
            SeleniumUtils.maximizeBrowserWindow();
            SeleniumUtils.deleteAllCookies();
            SeleniumUtils.setWebDriverTimeouts();
            SeleniumUtils.navigateToUrl(prop.getProperty("url"));
            instantiatePages();
            logger.info("TestBase initialization done");
            test.log(Status.INFO, "TestBase initialization complete");
        } catch (Exception e) {
            test.log(Status.FAIL, "TestBase Initialization Failed - " + e.getMessage());

            logger.error("TestBase Initialization Failed");
            e.printStackTrace();
        }
    }

//    private static Properties loadProperties(String filePath) {
//        Properties properties = new Properties();
//        try (FileInputStream input = new FileInputStream(System.getProperty("user.dir") + TEST_RESOURCES + filePath)) {
//            properties.load(input);
//            logger.info("TestBase config.properties has been loaded");
//        } catch (IOException io) {
//            logger.error("Error loading properties file: " + filePath);
//            io.printStackTrace();
//        }
//        return properties;
//    }

   

    private static void instantiatePages() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        logger.info("Initialized pages: LoginPage, HomePage");
    }
}
