package stepDefinitions;
import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;

import io.cucumber.java.en.Given;

public class HomePageTest extends TestBase{
	public HomePageTest(){
		super();
		logger.info("****** HomePageTest Constructor loaded ");
	}

	@Given("user selects an item from dropdown {string} from {string}")
	public void userSelectsItemFromDropdown(String itemToSelect, String weDropdown) throws InterruptedException {
		if(homePage.selectItemFromDropdown(itemToSelect, weDropdown)) {
			Hooks.test.log(Status.PASS, "SelectItemFromSeleniumDropdown Passed - item '" + itemToSelect + "' selected");
			logger.info("****** SelectItemFromSeleniumDropdown Passed - item '" + itemToSelect + "' selected ");}
		else {
			Hooks.test.log(Status.FAIL, "SelectItemFromSeleniumDropdown Failed - item '" + itemToSelect + "' Not selected ");
			logger.error("****** SelectItemFromSeleniumDropdown Failed - item '" + itemToSelect + "' Not selected ");}
	}
	//=======================Orange HRM============================
	@Given("user searches employee details {string} {string} {string} {string}")
	//   @Test
	public void useSearchesEmployeeDetails(String UserName, String UserRele, String EmpName, String EmpStatus) throws InterruptedException{
		
			if(homePage.searchSystemUserInOrangeHrm(UserName, UserRele, EmpName, EmpStatus)) {
			Hooks.test.log(Status.PASS, "searchUserHomePageTest passed ");
			logger.info("****** searchUserHomePageTest passed  ");
		}
			else {
			Hooks.test.log(Status.FAIL, "searchUserHomePageTest failed");
			logger.error("****** searchUserHomePageTest failed  ");}
		
		//		 TestRunner.extent.addTestRunnerOutput("ext TEST1  \r\n");
	}


}