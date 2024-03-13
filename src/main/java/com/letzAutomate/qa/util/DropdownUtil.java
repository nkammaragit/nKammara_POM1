package com.letzAutomate.qa.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.letzAutomate.qa.base.TestBase;

public class DropdownUtil extends TestBase {

	public static boolean selectItemFromDDL(String itemToSelect,WebElement weDropdown) {
		boolean status= false;
		try {
			if(MiscUtils.isInteger(itemToSelect)) {
				status = DropdownUtil.selectOptionFromDropdown(Integer.parseInt(itemToSelect),weDropdown );
			}
			else {
				status = DropdownUtil.selectOptionFromDropdown(itemToSelect,weDropdown); }
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		return status;
	}

	// Select Item by visibleText
	public static boolean selectOptionFromDropdown(String visibleText,WebElement dropdownElement) throws InterruptedException {
		try {
//			Thread.sleep(5000);
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByVisibleText(visibleText); 
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	// Select Item by id
	public static boolean selectOptionFromDropdown(int index, WebElement dropdownElement ) {
		try {
//			Thread.sleep(5000);
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
