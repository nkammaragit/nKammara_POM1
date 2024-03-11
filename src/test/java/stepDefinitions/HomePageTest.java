package stepDefinitions;
import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;
import com.letzAutomate.qa.pages.HomePage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class HomePageTest extends TestBase{
	public HomePageTest(){
		super();
		logger.info("****** HomePageTest Constructor loaded ");
	}

	@Given("user selects an item from dropdown {string} from {string}")
	public void userSelectsItemFromDropdown(String itemToSelect, String weDropdown) throws InterruptedException {
		if(TestBase.homePage.selectItemFromDropdown(itemToSelect, weDropdown)) {
			Hooks.test.log(Status.PASS, "SelectItemFromSeleniumDropdown Passed - item '" + itemToSelect + "' selected");
			logger.info("****** SelectItemFromSeleniumDropdown Passed - item '" + itemToSelect + "' selected ");}
		else {
			Hooks.test.log(Status.FAIL, "SelectItemFromSeleniumDropdown Failed - item '" + itemToSelect + "' Not selected ");
			logger.error("****** SelectItemFromSeleniumDropdown Failed - item '" + itemToSelect + "' Not selected ");}
	}
	//=======================Orange HRM============================
	@Given("user searches employee details")
	//   @Test
	public void searchUserHomePageTest(){
		try {
			Hooks.test.log(Status.PASS, "searchUserHomePageTest passed ");
			logger.info("****** searchUserHomePageTest passed  ");
		}
		catch (Exception e){
			Hooks.test.log(Status.FAIL, "searchUserHomePageTest failed");
			logger.error("****** searchUserHomePageTest failed  ");
		}
		//		 TestRunner.extent.addTestRunnerOutput("ext TEST1  \r\n");
	}


}