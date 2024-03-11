package com.letzAutomate.qa.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.util.DropdownUtil;
import com.letzAutomate.qa.util.MiscUtils;
import com.letzAutomate.qa.util.SeleniumUtils;
public class HomePage extends TestBase {
	private Map<String, WebElement> elementDdlMap = new HashMap<>();

	//===================HomePage Guru99=======================
	@FindBy(xpath="(//a[@data-toggle='dropdown'])[1]")
	WebElement dropdownSelenium ;

	@FindBy(xpath="//ul[@class='dropdown-menu']//li//a[contains(text(),'Guru99')]")
	WebElement itemGuru99;

	@FindBy(xpath="//a[contains(text(),'Testing')]")
	static WebElement linkTesting ;

	//===================HomePage OrangeHRM=======================
	@FindBy(xpath="//span[text()='Admin']")
	static WebElement linkAdmin ;

	//Username input : 
	@FindBy(xpath="//label[contains(text(),'Username')]/parent::div/parent::div//input[@class='oxd-input oxd-input--active']")
	WebElement inputUserName;

	//User Role dropdown:
	@FindBy(xpath="//label[contains(text(),'User Role')]/parent::div/parent::div//div[contains(text(),'Select')]")
	WebElement dropdownUserRole;

	//Employee Name input:
	@FindBy(xpath="//label[contains(text(),'Employee Name')]/parent::div/parent::div//input")
	WebElement inputEmployeeName ; 

	//Status dropdown:
	@FindBy(xpath="//label[contains(text(),'Status')]/parent::div/parent::div//div[contains(text(),'Select')]")
	WebElement dropdownStatus ; 

	public HomePage(){
		try {
			PageFactory.initElements(driver, this);
			logger.info("****** HomePage constructor loaded (PageFactory) ");	
		}
		catch(InvalidSelectorException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	//=================Guru 99=====================
	public static boolean verifyHomePagePostLogin(String siteName) {
		boolean loginSuccess= false;
		
		if(siteName.equalsIgnoreCase("guru99")) {
			loginSuccess =SeleniumUtils.isElementDisplayed(linkTesting);}
//			loginSuccess = driver.findElement(By.xpath("//h3[contains(text(),'Successfully Logged in')]")).isDisplayed();
//		}
		if(siteName.equalsIgnoreCase("orangehrm")) {
			loginSuccess =SeleniumUtils.isElementDisplayed(linkAdmin);
//			loginSuccess = driver.findElement(By.xpath("//span[text()='Admin']")).isDisplayed();
		}
		return loginSuccess;
	}
	public boolean selectItemFromDropdown(String itemToSelect, String weDropdown) throws InterruptedException {
		elementDdlMap.put("dropdownSelenium", dropdownSelenium);
		elementDdlMap.put("dropdownUserRole", dropdownUserRole);
		elementDdlMap.put("dropdownStatus", dropdownStatus);
		boolean status = false;
		try {
			DropdownUtil.selectItemFromDDL(itemToSelect,elementDdlMap.get(weDropdown) );
		}
		catch (NoSuchElementException e) {
			e.getMessage();
		}
		return status;
	}
	//===============Orange HRM=======================
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean searchSystemUserInOrangeHrm(String itemToSelect, String weDropdown) throws InterruptedException {
		elementDdlMap.put("dropdownSelenium", dropdownSelenium);
		elementDdlMap.put("dropdownUserRole", dropdownUserRole);
		elementDdlMap.put("dropdownStatus", dropdownStatus);
		boolean status = false;
		try {
			DropdownUtil.selectItemFromDDL(itemToSelect,elementDdlMap.get(weDropdown) );
		}
		catch (NoSuchElementException e) {
			e.getMessage();
		}
		return status;
	}
}