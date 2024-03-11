package stepDefinitions;
import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.pages.LoginPage;

import io.cucumber.java.en.Given;

public class LoginPageTest extends TestBase{
	public LoginPageTest(){
		super();
		TestBase.initialization();
		loginPage = new LoginPage();
		logger.info("****** LoginPageTest Constructor loaded ");
	}

	@Given ("user validates login functionality of {string}")
	public void loginTest(String siteName){
		String userName=null, password=null ;
		if(siteName.equalsIgnoreCase("orangehrm")) {userName="unameOrange"; password= "pwdOrange";}
		if(siteName.equalsIgnoreCase("guru99")) {userName="unameGuru"; password= "pwdGuru";}
		if(loginPage.login(siteName,prop.getProperty(userName), prop.getProperty(password))){
			Hooks.test.log(Status.PASS, "loginTest passed");
			logger.info("****** loginTest passed ");
		}
		else {
			Hooks.test.log(Status.FAIL, "loginTest Failed");
			logger.error("****** loginTest Failed ");	
		}
	}
}