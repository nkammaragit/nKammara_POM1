package com.letzAutomate.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.util.ExtentManager;



public class LoginPage extends TestBase{
	
	 ExtentTest test = ExtentManager.getExtentTest();
	//=====================GURU 99=================================
	
	@FindBy(xpath="//input[@name='email']")
	WebElement username2;
	
	@FindBy(xpath="//input[@name='passwd']")
	WebElement password2;
	
	@FindBy(xpath="//button[@name='SubmitLogin']")
	WebElement loginBtn2;
	
	
	//=====================ORANGE HRM=================================

	//Page Factory - OR:
	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	//	@FindBy(xpath="//input[@type='submit']")
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	@FindBy(xpath="//div[contains(@class,'orangehrm-login-logo-mobile')]//img")
	WebElement crmLogo;

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}

//	public HomePage login(String un, String pwd){
//		username.sendKeys(un);
//		password.sendKeys(pwd);
//		loginBtn.click();
//		return new HomePage();
//	}
	
	public HomePage login(String un, String pwd){
		try {
		
		username2.sendKeys(un);
		test.log(Status.INFO, "username2 given");	
		password2.sendKeys(pwd);
		test.log(Status.INFO, "password2 given");
		loginBtn2.click();
		test.log(Status.INFO, "Login button clicked");
		}
		catch(Exception e) {
	
			test.log(Status.FAIL, e.getMessage());	
		}
		return new HomePage();
	}


}