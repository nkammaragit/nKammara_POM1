package com.letzAutomate.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
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

	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	@FindBy(xpath="//div[contains(@class,'orangehrm-login-logo-mobile')]//img")
	WebElement crmLogo;

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
		logger.info("****** LoginPage Constructor loaded ********");
	}

	public boolean login(String siteName, String un, String pwd) {
		boolean loginStatus=false;
		try {
			if(siteName.equalsIgnoreCase("orangehrm")) {
				username.sendKeys(un);
				test.log(Status.INFO, "username is set");	
				password.sendKeys(pwd);
				test.log(Status.INFO, "password is set");
				loginBtn.click();
				test.log(Status.INFO, "Login button clicked");
				logger.info("****** login credentials entered  ********");}

			if(siteName.equalsIgnoreCase("guru99")) {
				username2.sendKeys(un);
				test.log(Status.INFO, "username2 given");	
				password2.sendKeys(pwd);
				test.log(Status.INFO, "password2 given");
				loginBtn2.click();
				test.log(Status.INFO, "Login button clicked");
				logger.info("****** login credentials entered  ********");}

			if(HomePage.verifyHomePagePostLogin(siteName)) {
				loginStatus = true;
			}
		}

		catch (TimeoutException te) {
			test.log(Status.FAIL, "TimeoutException occurred: " + te.getMessage());
		} catch (Exception e) {
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());   
		}
		return loginStatus;
	}
}