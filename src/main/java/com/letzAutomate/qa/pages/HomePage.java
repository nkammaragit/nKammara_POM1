package com.letzAutomate.qa.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.util.DropdownUtil;
import com.letzAutomate.qa.util.ExtentManager;
import com.letzAutomate.qa.util.MiscUtils;
import com.letzAutomate.qa.util.SeleniumUtils;
public class HomePage extends TestBase {
	
	ExtentTest test = ExtentManager.getExtentTest();
	
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
	static
	WebElement inputUserName;

	//User Role dropdown:
	@FindBy(xpath="//label[contains(text(),'User Role')]/parent::div/parent::div//div[contains(text(),'Select')]")
	static
	WebElement dropdownUserRole;

	//Employee Name input:
	@FindBy(xpath="//label[contains(text(),'Employee Name')]/parent::div/parent::div//input")
	static
	WebElement inputEmployeeName ; 

	//Status dropdown:
	@FindBy(xpath="//label[contains(text(),'Status')]/parent::div/parent::div//div[contains(text(),'Select')]")
	static
	WebElement dropdownStatus ; 

	@FindBy(xpath="//button[@type='submit']")
	static WebElement btnSearch ;
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
		if(siteName.equalsIgnoreCase("orangehrm")) {
			loginSuccess =SeleniumUtils.isElementDisplayed(linkAdmin);}
		return loginSuccess;
	}
	public boolean selectItemFromDropdown(String weDropdown,String itemToSelect) throws InterruptedException {
		elementDdlMap.put("dropdownSelenium", dropdownSelenium);
		elementDdlMap.put("dropdownUserRole", dropdownUserRole);
		elementDdlMap.put("dropdownStatus", dropdownStatus);
		boolean status = false;
		try {
			SeleniumUtils.selectDropdown(elementDdlMap.get(weDropdown),itemToSelect);
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

	public boolean searchSystemUserInOrangeHrm(String UserName, String UserRole, String EmployeeName, String empStatus) throws InterruptedException{
		boolean status = false;
		try {
			SeleniumUtils.clickElement(linkAdmin);
			SeleniumUtils.setInputText(inputUserName,UserRole);
			//		SeleniumUtils.selectDropdown(dropdownUserRole,UserRole);
			SeleniumUtils.setInputText(inputEmployeeName,EmployeeName);
			//		SeleniumUtils.selectDropdown(dropdownStatus,empStatus);
			SeleniumUtils.clickElement(btnSearch);
			test.log(Status.INFO, "Search system user is done ");
			status= true;}
		catch (NoSuchElementException | ElementNotInteractableException e) {
			e.getMessage();
		}	
		return status; 
	}}