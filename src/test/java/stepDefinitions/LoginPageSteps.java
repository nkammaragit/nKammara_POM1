package stepdefinitions;
import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.pages.LoginPage;

import io.cucumber.java.en.Given;

public class LoginPageSteps extends TestBase{
	public LoginPageSteps(){
		super();
		TestBase.initialization();
		logger.info("****** LoginPageTest Constructor loaded ");
	}

	@Given ("user validates login functionality of {string}")
	public void loginTest(String siteName){
		String userName=null, password=null ;
		if(siteName.equalsIgnoreCase("orangehrm")) {userName="unameOrange"; password= "pwdOrange";}
		if(siteName.equalsIgnoreCase("guru99")) {userName="unameGuru"; password= "pwdGuru";}
		
		if(loginPage.login(siteName,prop.getProperty(userName), prop.getProperty(password))){
			test.log(Status.PASS, siteName + " - loginTest Passed");
			logger.info("****** "+  siteName + " - loginTest Passed");
		}
		else {
			test.log(Status.FAIL, siteName + " - loginTest Failed");
			logger.error("****** " +  siteName + " - loginTest Failed");
		}
	}
}