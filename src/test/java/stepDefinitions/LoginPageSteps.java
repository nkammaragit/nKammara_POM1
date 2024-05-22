package stepdefinitions;
import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends TestBase{
	

//	public LoginPageSteps(){
//		super();

	@Given ("user is on Login page")
	public void InitializeWebDriverAndURL(){
		TestBase.initialization();
		logger.info("****** LoginPageTest Constructor loaded ");
	}


	@When ("user validates login functionality of {string}")
	public void loginTest(String siteName){
		String userName=null, password=null ;
		if(siteName.equalsIgnoreCase("orangehrm")) {userName="unameOrange"; password= "pwdOrange";}
		if(siteName.equalsIgnoreCase("guru99")) {userName="unameGuru"; password= "pwdGuru";}
		
		if(loginPage.login(siteName,prop.getProperty(userName), prop.getProperty(password))){
			test.log(Status.PASS, siteName + " - User successfully entered login credentials");
			logger.info("****** "+  siteName + " - User successfully entered login credentials");
		}
		else {
			test.log(Status.FAIL, siteName + " - User failed to log in");
			logger.error("****** " +  siteName + " - User failed to log in");
		}
	}
	
	 @Then("user should see the Home page")
	public void VerifyLoginIsSuccess() {
//	        boolean isWelcomeMessageDisplayed = driver.getPageSource().contains("Home");
	        boolean isWelcomeMessageDisplayed =  driver.getCurrentUrl().contains("dashboard");

	       
	        if (!isWelcomeMessageDisplayed) {
	        	test.log(Status.FAIL,  " - User failed to log in");
				logger.error("****** " +   " - User failed to log in");
	        	
	            throw new AssertionError("Welcome message not displayed");
	        }
	        else {
	        	test.log(Status.PASS, " - User successfully Logged in");
				logger.info("****** "+  " - User successfully Logged in");
	        	
	        }
//	        driver.quit();
	    }
}