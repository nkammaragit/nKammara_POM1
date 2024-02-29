package stepDefinitions;
import static org.testng.Assert.assertEquals;

import java.net.SocketException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.pages.HomePage;
import com.letzAutomate.qa.pages.LoginPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	public static HomePage homePage; 
	
	
	public LoginPageTest(){
		super();
	}

	@Before  //Its a BeforeMethod in lab
	public void setUp(){
		TestBase.initialization();
		loginPage = new LoginPage();	
	}

	@Given("user validates login page title")
	//   @Test
	public void loginPageTitleTest(){
		try {
			String title = loginPage.validateLoginPageTitle();
			assertEquals(title, "OrangeHRM");
			
			Hooks.test.log(Status.PASS, "validateLoginPageTitle passed ");
		}
		catch (AssertionError e){
			Hooks.test.log(Status.FAIL, "validateLoginPageTitle failed");	
		}
		//		 Hooks.extent.addHooksOutput("ext TEST1  \r\n");
	}

	@When("user validates logo image")
	//   @Test(priority=1)
	//@Test
	public void crmLogoImageTest() throws SocketException{
		try {
			boolean flag = loginPage.validateCRMImage();
			Assert.assertTrue(flag);
			//		 Hooks.extent.addHooksOutput("ext TEST2 \r\n");
			Hooks.test.log(Status.PASS, "validateCRMImage passed ");
		}
		catch (AssertionError e){
			Hooks.test.log(Status.FAIL, "validateCRMImage failed");	
		}
	}
	@Given("user validates login functionality")
//	public void loginTest(){
	public HomePage loginTest(){
		try {
//			homePage = loginPage.login(prop.getProperty("username2"), prop.getProperty("password2"));
			homePage = loginPage.login(prop.getProperty("username2"), prop.getProperty("password2"));
			Hooks.test.log(Status.PASS, "loginTest passed ");
		}
		
	     catch (TimeoutException te) {
	        Hooks.test.log(Status.FAIL, "loginTest failed due to timeout");
	    } catch (NoSuchElementException nsee) {
	        Hooks.test.log(Status.FAIL, "loginTest failed due to missing elements");
	    } catch (WebDriverException wde) {
	        Hooks.test.log(Status.FAIL, "loginTest failed due to WebDriver issues");
	    } catch (Exception e) {
	        Hooks.test.log(Status.FAIL, "loginTest failed due to unexpected error: " + e.getMessage());
	    }
		return homePage;
	}

}