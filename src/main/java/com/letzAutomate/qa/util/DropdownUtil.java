package com.letzAutomate.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.letzAutomate.qa.base.TestBase;

public class DropdownUtil extends TestBase {
   
//    public void selectOptionFromDropdown(String locater, String visibleText) throws InterruptedException {
public void selectOptionFromDropdown(WebElement dropdownElement, String visibleText) throws InterruptedException {
//	WebElement dropdownElement = driver.findElement(By.xpath(locater));
	try {
     	System.out.println(dropdownElement.isDisplayed());
//    	 dropdownElement.click();
    	 Thread.sleep(5000);
    	Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText); 
        System.out.println("visibleText Select : "+ visibleText);   
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
    }

    // Select option by id
    public void selectOptionFromDropdown(WebElement dropdownElement, int index) {
    	try {
         	System.out.println(dropdownElement.isDisplayed());
//        	 dropdownElement.click();
        	 Thread.sleep(5000);
        	Select dropdown = new Select(dropdownElement);
            dropdown.deselectByIndex(1);
            System.out.println("Index Selected : "+ index);   
            }
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
}
}
