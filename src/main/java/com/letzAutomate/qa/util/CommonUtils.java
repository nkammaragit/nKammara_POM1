package com.letzAutomate.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.letzAutomate.qa.base.TestBase;

public class CommonUtils {
	public static Properties prop;
	// Method to check if a string can be parsed as an integer
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
        public static void captureScreenshot(WebDriver driver, String screenshotName) {
            try {
                String targetPath  = "target/screenshots/";
                TakesScreenshot ts = (TakesScreenshot) TestBase.driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));
                FileUtils.copyFile(source, new File(targetPath + screenshotName + ".png"));
                System.out.println("Screenshot captured");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot: " + e.getMessage());
            }
        }

        
        
        public static String getPropertyValue(String filePath, String key) {
             prop = new Properties();
            FileInputStream input = null;
            String value = null;
            
            try {
                input = new FileInputStream(filePath);
                prop.load(input);
                value = prop.getProperty(key);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return value;
        }
        
}
