package com.letzAutomate.qa.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;

import com.letzAutomate.qa.base.TestBase;

public class QuitAllBrowsers extends TestBase {
	public static void quitAllBrowsers() {
		  // Set implicit wait to handle timing issues
       
		        
		 Set<String> windowHandles = driver.getWindowHandles();

	        for (String handle : windowHandles) {
	            try {
	                driver.switchTo().window(handle);
	                driver.close();
	            } catch (Exception e) {
	                // Handle any exceptions, such as the window already closed
	                System.out.println("Exception occurred while closing window with handle: " + handle);
	            }
	        }
    driver.quit();
    }
}
