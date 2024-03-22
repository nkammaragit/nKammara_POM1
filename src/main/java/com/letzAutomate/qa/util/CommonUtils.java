package com.letzAutomate.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.letzAutomate.qa.base.TestBase;

public class CommonUtils {
	public static Properties prop;
    private static final String TEST_RESOURCES = "/src/test/resources";

	// Method to check if a string can be parsed as an integer
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    

        
        // Method to get property value from properties file      
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
        // Method to rename file with timestamp       
        public static String renameFileWithTimestamp(String filePath) {
    		File file = new File(filePath);
    		String newFileName = null;
    		// Check if the file exists
    		if (file.exists()) {
    			// Get the current timestamp
    			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
    			String timestamp = dateFormat.format(new Date());
    			// Get the file extension
    			int dotIndex = filePath.lastIndexOf('.');
    			String extension = "";
    			if (dotIndex >= 0 && dotIndex < filePath.length() - 1) {
    				extension = filePath.substring(dotIndex);
    			}
    			// Construct the new file name with timestamp
    			newFileName = file.getParent() + File.separator + "Extent_" + timestamp + extension;
    			// Create a new File object with the new file name
    			File newFile = new File(newFileName);
    			// Rename the file
    			if (file.renameTo(newFile)) {
    				System.out.println("File renamed successfully to: " + newFileName);
    				return newFileName ;

    			} else {
    				System.err.println("Failed to rename the file.");
    			}
    		} else {
    			System.err.println("File not found: " + filePath);
    		}
    		return newFileName ;
    	}
        
     // Method to load properties from file      
        public static Properties loadProperties(String filePath) {
            Properties properties = new Properties();
            try (FileInputStream input = new FileInputStream(System.getProperty("user.dir") + TEST_RESOURCES + filePath)) {
                properties.load(input);
                System.out.println("TestBase config.properties has been loaded");
            } catch (IOException io) {
            	System.out.println("Error loading properties file: " + filePath);
                io.printStackTrace();
            }
            return properties;
        }
     // Method to get property value from properties file
        public static String getPropertyFromPropertiesFile(String filePath, String key) {
            Properties properties = loadProperties(filePath);
            return properties.getProperty(key);
        }

        //Method to update properties file at runtime    
        public static void updateProperty(String filePath, String keyToUpdate, String newValue) {
            try {
                // Load properties file
                Properties properties = new Properties();
                FileInputStream fileInputStream = new FileInputStream(filePath);
                properties.load(fileInputStream);
                fileInputStream.close();

                // Update the property value
                properties.setProperty(keyToUpdate, newValue);

                // Save the updated properties file
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                properties.store(fileOutputStream, null);
                fileOutputStream.close();

                System.out.println("Property updated successfully.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
}
