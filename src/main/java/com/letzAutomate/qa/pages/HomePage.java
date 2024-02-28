package com.letzAutomate.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.util.DropdownUtil;
//import StepDefinitions.TestRunner;
public class HomePage extends TestBase {
	
	
	//===================HomePage Guru99=======================
//	@FindBy(xpath="(//a[@data-toggle='dropdown'])[1]")
	@FindBy(xpath="(//li[@class='dropdown'])[1]")
	WebElement dropdownSelenium ;
	@FindBy(xpath="//a[contains(text(),'Testing')]")
	WebElement linkTesting ;
	
	//===================HomePage OrangeHRM=======================
	//	@FindBy(xpath="//span[text()='Admin']")
	//	WebElement linkAdmin ;
	// Initializing the Page Objects:
		
	public HomePage(){
		try {
			PageFactory.initElements(driver, this);}
		catch(InvalidSelectorException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	
	DropdownUtil du= new DropdownUtil();
	//=================Guru 99=====================
	public boolean verifyHomePagePostLogin() {
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Successfully Logged in')]")).isDisplayed());
		return driver.findElement(By.xpath("//h3[contains(text(),'Successfully Logged in')]")).isDisplayed();
	}
	
	public boolean selectItemFromDropdown(String dropdownName, Object itemToSelect) throws InterruptedException {
	 boolean status = false;
//	 int intValue = 0 ;
//	 String stringValue =null;
//	 if (itemToSelect instanceof Integer) {
//          intValue = (Integer) itemToSelect;
//         System.out.println("Received an integer: " + intValue);
//     } else if (itemToSelect instanceof String) {
//          stringValue = (String) itemToSelect;
//         System.out.println("Received a string: " + stringValue);
//     } else {
//         System.out.println("Unsupported data type");
//     }
		try {
		switch(dropdownName) {
		case "selenium":
			System.out.println( "linkTesting *** " + linkTesting.isDisplayed());
			System.out.println("dropdownSelenium *** " + dropdownSelenium.isDisplayed());
			
			if (itemToSelect instanceof Integer) {
	          int intValue = (Integer) itemToSelect;
			du.selectOptionFromDropdown(dropdownSelenium,intValue);}
			else if (itemToSelect instanceof String) {
		          String stringValue = (String) itemToSelect;
				du.selectOptionFromDropdown(dropdownSelenium,stringValue);
			}
//			du.selectOptionFromDropdown("(//a[@data-toggle='dropdown'])[1]",itemToSelect);
			 status = true;
		case "other":
			
		}}
		catch (NoSuchElementException e) {
			e.getMessage();
		}
		return status;
	}
//===============Orange HRM=======================
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
}