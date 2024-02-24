package com.letzAutomate.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letzAutomate.qa.base.TestBase;

//import StepDefinitions.TestRunner;

public class HomePage extends TestBase {

	//===================HomePage Guru99=======================
	@FindBy(xpath="(//a[@class=\"dropdown-toggle\"]//text())[1]")
	WebElement txtSuccessfulLogin ;

	//===================HomePage OrangeHRM=======================

	//	@FindBy(xpath="//span[text()='Admin']")
	//	WebElement linkAdmin ;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	//=================Guru 99=====================

	public boolean verifyHomePagePostLogin() {
		return driver.findElement(By.xpath("//h3[contains(text(),'Successfully Logged in')]")).isDisplayed();
	}
	//===============Orange HRM=======================

	public String verifyHomePageTitle(){
		return driver.getTitle();
	}

}