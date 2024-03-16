package com.letzAutomate.qa.util;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.letzAutomate.qa.base.TestBase;

import java.time.Duration;
import java.util.List;

public class SeleniumUtils extends TestBase{
	
	public static void clickElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			logger.info("****** Clicked on element: " + element.toString());
		} catch (NoSuchElementException | ElementNotInteractableException | TimeoutException e) {
			logger.error("****** Failed to click element: " + element.toString() + " - " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void setInputText(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
			logger.info("****** Entered text '" + text + "' in element: " + element.toString());
		} catch (NoSuchElementException | ElementNotInteractableException e) {
			logger.error("****** Failed to set text in element: " + element.toString() + " - " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void checkCheckbox(WebElement checkbox) {
		try {
			if (!checkbox.isSelected()) {
				clickElement(checkbox);
				logger.info("****** Checkbox checked: " + checkbox.toString());
			}
		} catch (NoSuchElementException e) {
			logger.error("****** Failed to check checkbox: " + checkbox.toString() + " - " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void uncheckCheckbox(WebElement checkbox) {
		try {
			if (checkbox.isSelected()) {
				clickElement(checkbox);
				logger.info("****** Checkbox unchecked: " + checkbox.toString());
			}
		} catch (NoSuchElementException e) {
			logger.error("****** Failed to uncheck checkbox: " + checkbox.toString() + " - " + e.getMessage());
			e.printStackTrace();
		}
	}
//Select by visible text
	public static boolean selectOptionFromDropdown(String visibleText,WebElement dropdownElement) throws InterruptedException {
		try {
			Select select = new Select(dropdownElement);
			select.selectByVisibleText(visibleText); 
			logger.info("****** Dropdown selected by visible text: " + visibleText);
			return true;
		}
		catch(Exception e) {
			logger.error("****** Failed to select dropdown by visible text: " + visibleText + " - " + e.getMessage());
			return false;
		}
	}
	// Select Item by id
	public static boolean selectOptionFromDropdown(int index, WebElement dropdownElement ) {
		try {
			Select select = new Select(dropdownElement);
			select.selectByIndex(index);
			logger.info("****** Dropdown selected by index: " + index);
			return true;
		}
		catch(Exception e) {
			logger.error("****** Failed to select dropdown by index: " + index + " - " + e.getMessage());
			return false;
		}
	}

	
	public static boolean selectDropdown(WebElement weDropdown,String itemToSelect) {
		boolean status= false;
		try {
			if(MiscUtils.isInteger(itemToSelect)) {
				status = selectOptionFromDropdown(Integer.parseInt(itemToSelect),weDropdown );
			}
			else {
				status = selectOptionFromDropdown(itemToSelect,weDropdown); }
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		return status;
	}

	public void selectRadioButton(List<WebElement> radioButtons, String value) {
		try {
			for (WebElement radioButton : radioButtons) {
				if (radioButton.getAttribute("value").equalsIgnoreCase(value)) {
					clickElement(radioButton);
					logger.info("****** Radio button selected: " + radioButton.toString());
					break;
				}
			}
		} catch (NoSuchElementException e) {
			logger.error("****** Failed to select radio button: " + value + " - " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickTableCell(WebElement table, int rowIndex, int colIndex) {
		try {
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			WebElement row = rows.get(rowIndex);
			List<WebElement> cells = row.findElements(By.tagName("td"));
			WebElement cell = cells.get(colIndex);
			clickElement(cell);
			logger.info("****** Clicked on table cell at row " + rowIndex + ", column " + colIndex);
		} catch (NoSuchElementException e) {
			logger.error("****** Failed to click table cell at row " + rowIndex + ", column " + colIndex + " - " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            logger.error("****** Element is not displayed: " + element.toString() + " - " + e.getMessage());
            return false;
        }
    }
	
	public static void handleAlert() {
        String alertText = null;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);
            alert.accept();
        } catch (Exception e) {
            // Handle exceptions if the alert doesn't exist or any other issue
            e.printStackTrace();
        }
//        return alertText;
    }
	
	     public static boolean isAlertPresent() {
	        try {
	            driver.switchTo().alert();
	            return true;
	        } catch (NoAlertPresentException e) {
	            return false;
	        }
	    }
	     
	     //Handling div (non standard) dropdowns 
//	     public static void handleDivDropdown(WebElement dropdownElement, WebElement optionElement) {
//	         // Click on the dropdown to open it
//	         dropdownElement.click();
//	         // Click on the option to select it
//	         optionElement.click();
//	         dropdownElement.sendKeys();
//	     }
	
	     public static void handleDivDropdown(WebElement dropdownElement, WebElement optionElement) {
	     driver.findElement(By.name("JDK")).click();
	        List<WebElement> allOptions = driver.findElements(By.xpath("//select[@name='JDK']//option"));
	        System.out.println(allOptions.size());                                           
	        for(int i = 0; i<=allOptions.size()-1; i++) {
	             if(allOptions.get(i).getText().contains("JDK 1.8")) {
	                    allOptions.get(i).click();
	                break;
	             }
}}}
