package stepDefinitions;
import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class HomePageTest extends TestBase{
	//	LoginPage loginPage;
	//	HomePage homePage=LoginPageTest.homePage ;	
	HomePage homePage;
	//	TestBase testbase;

	public HomePageTest(){
		super();
	}

	@Before
	public void setUp(){
		//		TestBase.initialization();
		//		homePage = new HomePage();	

	}

	@Given("user lands to homepage")
	public void verifyUserLandsToHomePage() {

		if(LoginPageTest.homePage.verifyHomePagePostLogin())
			Hooks.test.log(Status.PASS, "Home page appeared - Login success ");
		else
			Hooks.test.log(Status.FAIL, "Home page not appeared - Login Failed");	
	}

	@Given("user selects an item from Selenium dropdown")
	public void SelectItemFromSeleniumDropdown() throws InterruptedException {

		if(LoginPageTest.homePage.selectItemFromDropdown("selenium", "Selenium IDE Test")) {
			Hooks.test.log(Status.PASS, "Selected 'Selenium IDE Test' from Selenium dropdown list");}
		else {
			Hooks.test.log(Status.FAIL, "Failed to selecte 'Selenium IDE Test' from Selenium dropdown list");}

//		if(LoginPageTest.homePage.selectItemFromDropdown("selenium", 5)) {
//			Hooks.test.log(Status.PASS, "Selected 'Selenium IDE Test' from Selenium dropdown list");}
//		else {
//			Hooks.test.log(Status.FAIL, "Failed to selecte 'index' from Selenium dropdown list");}

	}

	//=======================Orange HRM============================

	@Given("user searches employee details")
	//   @Test
	public void searchUserHomePageTest(){
		try {
			Hooks.test.log(Status.PASS, "searchUserHomePage passed ");
		}
		catch (Exception e){
			Hooks.test.log(Status.FAIL, "searchUserHomePage failed");	
		}
		//		 TestRunner.extent.addTestRunnerOutput("ext TEST1  \r\n");
	}


}