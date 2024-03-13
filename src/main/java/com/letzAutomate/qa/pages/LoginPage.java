package com.letzAutomate.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.util.ExtentManager;
import com.letzAutomate.qa.util.SeleniumUtils;

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
		logger.info("****** LoginPage Constructor loaded ");
	}

	public boolean login(String siteName, String un, String pwd) {
		boolean loginStatus=false;
		try {
			if(siteName.equalsIgnoreCase("orangehrm")) {
				SeleniumUtils.setInputText(username,un);
				SeleniumUtils.setInputText(password,pwd);
				SeleniumUtils.clickElement(loginBtn);
				logger.info("****** login credentials entered ");}

			if(siteName.equalsIgnoreCase("guru99")) {
				SeleniumUtils.setInputText(username2,un);
				SeleniumUtils.setInputText(password2,pwd);
				SeleniumUtils.clickElement(loginBtn2);
				logger.info("****** login credentials entered ");}

			if(HomePage.verifyHomePagePostLogin(siteName)) {
				loginStatus = true;
				logger.info("****** Home page of " + siteName + " is displayed ");
				test.log(Status.INFO, "HomePage displayed");
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