package com.letzAutomate.qa.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.letzAutomate.qa.base.TestBase;

public class DropdownUtil extends TestBase {

	// Select Item by visibleText
	public static boolean selectOptionFromDropdown(String visibleText,WebElement dropdownElement) throws InterruptedException {
		try {
			System.out.println(dropdownElement.isDisplayed());
			Thread.sleep(5000);
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByVisibleText(visibleText); 
			logger.info("****** selectOptionFromDropdown selectByVisibleText Passed : " + visibleText);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			logger.info("****** selectOptionFromDropdown selectByVisibleText Failed : " + visibleText);
			return false;
		}
	}
	// Select Item by id
	public static boolean selectOptionFromDropdown(int index, WebElement dropdownElement ) {
		try {
			System.out.println(dropdownElement.isDisplayed());
			Thread.sleep(5000);
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByIndex(index);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
