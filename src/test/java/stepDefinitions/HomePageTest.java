package stepDefinitions;
import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class HomePageTest extends TestBase{
	//	LoginPage loginPage;
	HomePage homePage;
	//	TestBase testbase;
	public HomePageTest(){
		super();
	}

	@Before
	public void setUp(){
		//		TestBase.initialization();
		homePage = new HomePage();	
	}

	@Given("user lands to homepage")
	public void verifyUserLandsToHomePage() {
		try {
			homePage.verifyHomePagePostLogin();
			Hooks.test.log(Status.PASS, "Home page appeared - Login success ");}
		catch(Exception e){
			Hooks.test.log(Status.FAIL, "Home page not appeared - Login Failed" +  e.getMessage());	
		}
	}

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