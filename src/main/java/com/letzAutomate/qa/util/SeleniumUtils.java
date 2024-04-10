package com.letzAutomate.qa.util;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;

public class SeleniumUtils extends TestBase{
	

	 // Method to click an element
	public static boolean clickElement(WebElement element) {
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			logger.info("****** Clicked on element: " + element.toString());
		} catch (NoSuchElementException | ElementNotInteractableException | TimeoutException e) {
			test.log(Status.FAIL, "Failed to click element: " + element.toString() + " - " + e.getMessage());
			logger.error("****** Failed to click element: " + element.toString() + " - " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Method to set input text in a field
	public static boolean setInputText(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
			logger.info("****** Entered text '" + text + "' in element: " + element.toString());
		} catch (NoSuchElementException | ElementNotInteractableException e) {
			test.log(Status.FAIL, "Failed to set text in element: " + element.toString() + " - " + e.getMessage());
			logger.error("****** Failed to set text in element: " + element.toString() + " - " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

    // Method to check a checkbox
	public static boolean checkCheckbox(WebElement checkbox) {
		try {
			if (!checkbox.isSelected()) {
				clickElement(checkbox);
				logger.info("****** Checkbox checked: " + checkbox.toString());
			}
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Failed to check checkbox: " + checkbox.toString() + " - " + e.getMessage());

			logger.error("****** Failed to check checkbox: " + checkbox.toString() + " - " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Method to uncheck a checkbox
	public static boolean uncheckCheckbox(WebElement checkbox) {
		try {
			if (checkbox.isSelected()) {
				clickElement(checkbox);
				logger.info("****** Checkbox unchecked: " + checkbox.toString());
			}
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Failed to uncheck checkbox: " + checkbox.toString() + " - " + e.getMessage());

			logger.error("****** Failed to uncheck checkbox: " + checkbox.toString() + " - " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	// Method to select an option from a dropdown by visible text
	public static boolean selectOptionFromDropdown(String visibleText,WebElement dropdownElement) throws InterruptedException {
		try {
			Select select = new Select(dropdownElement);
			select.selectByVisibleText(visibleText); 
			logger.info("****** Dropdown selected by visible text: " + visibleText);
			return true;
		}
		catch(Exception e) {
			test.log(Status.FAIL, "Failed to select dropdown by visible text: " + dropdownElement.toString() + " - " + e.getMessage());

			logger.error("****** Failed to select dropdown by visible text: " + visibleText + " - " + e.getMessage());
			return false;
		}
	}
    // Method to select an option from a dropdown by index
	public static boolean selectOptionFromDropdown(int index, WebElement dropdownElement ) {
		try {
			Select select = new Select(dropdownElement);
			select.selectByIndex(index);
			logger.info("****** Dropdown selected by index: " + index);
			return true;
		}
		catch(Exception e) {
			test.log(Status.FAIL, "Failed to select dropdown by visible text: " + dropdownElement.toString() + " - " + e.getMessage());

			logger.error("****** Failed to select dropdown by index: " + index + " - " + e.getMessage());
			return false;
		}
	}

	 // Method to select an option from a dropdown
	public static boolean selectDropdown(WebElement weDropdown,String itemToSelect) {
		boolean status= false;
		try {
			if(CommonUtils.isInteger(itemToSelect)) {
				status = selectOptionFromDropdown(Integer.parseInt(itemToSelect),weDropdown );
			}
			else {
				status = selectOptionFromDropdown(itemToSelect,weDropdown); }
		} 
		catch (InterruptedException e) {
			test.log(Status.FAIL, "Failed to select dropdown " + weDropdown.toString() + " - " + e.getMessage());

			e.printStackTrace();
		}

		return status;
	}

	// Method to select a radio button
	public static boolean selectRadioButton(List<WebElement> radioButtons, String value) {
		try {
			for (WebElement radioButton : radioButtons) {
				if (radioButton.getAttribute("value").equalsIgnoreCase(value)) {
					clickElement(radioButton);
					logger.info("****** Radio button selected: " + radioButton.toString());
					break;
				}
			}
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Failed to select radio button: " + value + " - " + e.getMessage());

			logger.error("****** Failed to select radio button: " + value + " - " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	   // Method to click a table cell
	public static boolean clickTableCell(WebElement table, int rowIndex, int colIndex) {
		try {
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			WebElement row = rows.get(rowIndex);
			List<WebElement> cells = row.findElements(By.tagName("td"));
			WebElement cell = cells.get(colIndex);
			clickElement(cell);
			logger.info("****** Clicked on table cell at row " + rowIndex + ", column " + colIndex);
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Failed to click table cell at row " + rowIndex + ", column " + colIndex + " - " + e.getMessage());

			logger.error("****** Failed to click table cell at row " + rowIndex + ", column " + colIndex + " - " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	  // Method to check if an element is displayed
	public static boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException | ElementNotInteractableException e) {
			test.log(Status.FAIL, "Element is not displayed: " + element.toString() + " - " + e.getMessage());

			logger.error("****** Element is not displayed: " + element.toString() + " - " + e.getMessage());
			return false;
		}
	}

	 // Method to handle an alert
	public static void handleAlert() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
			System.out.println("Alert Text: " + alertText);
			alert.accept();
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to handle alert");

			// Handle exceptions if the alert doesn't exist or any other issue
			e.printStackTrace();
		}
		//        return alertText;
	}

	   // Method to check if an alert is present
	public static boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			test.log(Status.INFO, "Alert Present ");
		
		} catch (NoAlertPresentException e) {
			test.log(Status.INFO, "Alert Not Present ");

			return false;
		}
		return true;
	}

	//Handling div (non standard) dropdowns 
	//	     public static void handleDivDropdown(WebElement dropdownElement, WebElement optionElement) {
	//	         // Click on the dropdown to open it
	//	         dropdownElement.click();
	//	         // Click on the option to select it
	//	         optionElement.click();
	//	         dropdownElement.sendKeys();
	//	     }

	 // Method to handle a div (non-standard) dropdown
//	public static void handleDivDropdown(WebElement dropdownElement, WebElement optionElement) {
//		driver.findElement(By.name("JDK")).click();
//		List<WebElement> allOptions = driver.findElements(By.xpath("//select[@name='JDK']//option"));
//		System.out.println(allOptions.size());                                           
//		for(int i = 0; i<=allOptions.size()-1; i++) {
//			if(allOptions.get(i).getText().contains("JDK 1.8")) {
//				allOptions.get(i).click();
//				break;
//			}
//		}
//	}

	 // Method to quit all browser windows
	public static void quitAllBrowsers() {
		  // Set implicit wait to handle timing issues
 		 Set<String> windowHandles = driver.getWindowHandles();
	        for (String handle : windowHandles) {
	            try {
	                driver.switchTo().window(handle);
	                driver.close();
	            } catch (Exception e) {
	                // Handle any exceptions, such as the window already closed
	    			test.log(Status.FAIL, "Exception occurred while closing window with handle:" + handle);

	                System.out.println("Exception occurred while closing window with handle: " + handle);
	            }
	        }
	        driver.quit();
  }

	// Method to initialize the WebDriver with the specified browser
	 public static void initializeWebDriver(String browserName) {
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
	    			test.log(Status.FAIL, "Unsupported browser: " + browserName.toString() );

	                throw new IllegalArgumentException("Unsupported browser: " + browserName);
	        }
	        logger.info("Initialized WebDriver for: " + browserName);
	    }

	// Method to get the driver path
	 public static String getDriverPath(String driverName) {
	        return System.getProperty("user.dir") + TEST_RESOURCES + DRIVER_FOLDER_PATH + driverName;
	    }

	// Method to maximize the browser window
	 public static void maximizeBrowserWindow() {
	        driver.manage().window().maximize();
	    }
	// Method to delete all cookies
	 public static void deleteAllCookies() {
	        driver.manage().deleteAllCookies();
	    }

	// Method to set WebDriver timeouts
	 public static void setWebDriverTimeouts() {
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGELOAD_TIMEOUT));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.PAGELOAD_TIMEOUT));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.PAGELOAD_TIMEOUT));
	    }
	// Method to navigate to a URL
	 public static void navigateToUrl(String url) {
	        driver.get(url);
	        logger.info("Navigated to URL: " + url);
	    }
	 
	// Method to capture a screenshot   
     public static void captureScreenshot(WebDriver driver, String screenshotName) {
         try {
             String targetPath  = "target/screenshots/";
             TakesScreenshot ts = (TakesScreenshot) TestBase.driver;
             File source = ts.getScreenshotAs(OutputType.FILE);
//             FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));
             FileUtils.copyFile(source, new File(targetPath + screenshotName + ".png"));
             System.out.println("Screenshot captured");
         } catch (Exception e) {
 			test.log(Status.FAIL, "Exception while taking screenshot - " + e.getMessage());

             System.out.println("Exception while taking screenshot: " + e.getMessage());
         }
     }
}
