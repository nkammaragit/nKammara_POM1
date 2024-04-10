package com.letzAutomate.qa.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.util.CommonUtils;
import com.letzAutomate.qa.util.ExtentManager;
import com.letzAutomate.qa.util.SeleniumUtils;

public class LoginPage extends TestBase{

//	ExtentTest test = ExtentManager.getExtentTest();
	//=====================GURU 99=================================

	@FindBy(xpath="//input[@name='email']")
	private WebElement username2;

	@FindBy(xpath="//input[@name='passwd']")
	private WebElement password2;

	@FindBy(xpath="//button[@name='SubmitLogin']")
	private WebElement loginBtn2;

	//=====================ORANGE HRM=================================

	//Page Factory - OR:
	@FindBy(name="username")
	private WebElement username;

	@FindBy(name="password")
	private WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;

	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	private WebElement signUpBtn;

	@FindBy(xpath="//div[contains(@class,'orangehrm-login-logo-mobile')]//img")
	private WebElement crmLogo;

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
		logger.info("****** LoginPage PageFactory.initElements loaded ");
	}

	public boolean login(String siteName, String un, String pwd) {
		boolean loginStatus=false;
		try {
			if(siteName.equalsIgnoreCase("orangehrm")) {
				SeleniumUtils.setInputText(username,un);
				CommonUtils.waitInSeconds(5);
				SeleniumUtils.setInputText(password,pwd);
				CommonUtils.waitInSeconds(5);
				SeleniumUtils.clickElement(loginBtn);
				logger.info("****** login credentials entered ");

				if(SeleniumUtils.isAlertPresent()) SeleniumUtils.handleAlert();
				
				}

			if(siteName.equalsIgnoreCase("guru99")) {
				SeleniumUtils.setInputText(username2,un);
				CommonUtils.waitInSeconds(5);
				SeleniumUtils.setInputText(password2,pwd);
				CommonUtils.waitInSeconds(5);
				SeleniumUtils.clickElement(loginBtn2);
				logger.info("****** login credentials entered ");}

			if(HomePage.verifyHomePagePostLogin(siteName)) {
				loginStatus = true;
				logger.info(siteName + " - Home page is displayed ");
				test.log(Status.INFO, siteName + " - Home page is displayed ");
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