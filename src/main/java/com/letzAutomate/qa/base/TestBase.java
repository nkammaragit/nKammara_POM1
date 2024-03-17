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
import com.letzAutomate.qa.util.ExtentManager;
import com.letzAutomate.qa.util.StaticVariables;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait wait;
    public static org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestBase.class);
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static ExtentTest test;

    // Constants for file paths
    private static final String CONFIG_FILE_PATH = "/config/config.properties";
    private static final String DRIVER_FOLDER_PATH = "/drivers/";
    public static String testResources="/src/test/resources";

    public TestBase() {
        prop = loadProperties(CONFIG_FILE_PATH);
    }

    public static void initialization() {
        try {
            test = ExtentManager.getExtentTest();
            String browserName = prop.getProperty("browser");
            initializeWebDriver(browserName);
            maximizeBrowserWindow();
            deleteAllCookies();
            setWebDriverTimeouts();
            navigateToUrl(prop.getProperty("urlOrange"));
            instantiatePages();
            logger.info("TestBase initialization done");
            test.log(Status.INFO, "TestBase initialization done");
        } catch (Exception e) {
            logger.error("TestBase Initialization Failed");
            e.printStackTrace();
        }
    }

    private static Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(System.getProperty("user.dir") + testResources + filePath)) {
            properties.load(input);
            logger.info("TestBase config.properties has been loaded");
        } catch (IOException io) {
            logger.error("Error loading properties file: " + filePath);
            io.printStackTrace();
        }
        return properties;
    }

    private static void initializeWebDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", getDriverPath("chromedriver.exe"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", getDriverPath("geckodriver"));
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        logger.info("Initialized WebDriver for: " + browserName);
    }

    private static String getDriverPath(String driverName) {
        return System.getProperty("user.dir") + testResources + DRIVER_FOLDER_PATH + driverName;
    }

    private static void maximizeBrowserWindow() {
        driver.manage().window().maximize();
    }

    private static void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    private static void setWebDriverTimeouts() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(StaticVariables.PAGELOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(StaticVariables.PAGELOAD_TIMEOUT));
        wait = new WebDriverWait(driver, Duration.ofSeconds(StaticVariables.PAGELOAD_TIMEOUT));
    }

    private static void navigateToUrl(String url) {
        driver.get(url);
        logger.info("Navigated to URL: " + url);
    }

    private static void instantiatePages() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        logger.info("Initialized pages: LoginPage, HomePage");
    }
}
