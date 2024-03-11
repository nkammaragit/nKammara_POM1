package com.letzAutomate.qa.util;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.letzAutomate.qa.base.TestBase;

import java.time.Duration;
import java.util.List;

public class SeleniumUtils extends TestBase{

	public static WebDriver driver;
	public static WebDriverWait wait;

	public SeleniumUtils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public static void clickElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			logger.info("****** Clicked on element: " + element.toString());
		} catch (NoSuchElementException | ElementNotInteractableException | TimeoutException e) {
			logger.warn("****** Failed to click element: " + element.toString() + " - " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void setInputText(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
			logger.info("****** Entered text '" + text + "' in element: " + element.toString());
		} catch (NoSuchElementException | ElementNotInteractableException e) {
			logger.warn("****** Failed to set text in element: " + element.toString() + " - " + e.getMessage());
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
			logger.warn("****** Failed to check checkbox: " + checkbox.toString() + " - " + e.getMessage());
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
			logger.warn("****** Failed to uncheck checkbox: " + checkbox.toString() + " - " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void selectDropdownByVisibleText(WebElement dropdown, String visibleText) {
		try {
			Select select = new Select(dropdown);
			select.selectByVisibleText(visibleText);
			logger.info("****** Dropdown selected by visible text: " + visibleText);
		} catch (NoSuchElementException e) {
			logger.warn("****** Failed to select dropdown by visible text: " + visibleText + " - " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void selectDropdownByIndex(WebElement dropdown, int index) {
		try {
			Select select = new Select(dropdown);
			select.selectByIndex(index);
			logger.info("****** Dropdown selected by index: " + index);
		} catch (NoSuchElementException e) {
			logger.warn("****** Failed to select dropdown by index: " + index + " - " + e.getMessage());
			e.printStackTrace();
		}
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
			logger.warn("****** Failed to select radio button: " + value + " - " + e.getMessage());
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
			logger.warn("****** Failed to click table cell at row " + rowIndex + ", column " + colIndex + " - " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            logger.warn("****** Element is not displayed: " + element.toString() + " - " + e.getMessage());
            return false;
        }
    }

}
