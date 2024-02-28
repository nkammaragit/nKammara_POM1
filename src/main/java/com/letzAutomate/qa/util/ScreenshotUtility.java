package com.letzAutomate.qa.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.letzAutomate.qa.base.TestBase;

public class ScreenshotUtility extends TestBase {
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            String targetPath  = "target/screenshots/";
            TakesScreenshot ts = (TakesScreenshot) TestBase.driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));
            FileUtils.copyFile(source, new File(targetPath + screenshotName + ".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}