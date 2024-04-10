package stepdefinitions;
import com.aventstack.extentreports.Status;
import com.letzAutomate.qa.base.TestBase;

import io.cucumber.java.en.Given;

public class HomePageSteps extends TestBase{
	public HomePageSteps(){
		super();
		logger.info("****** HomePageTest Constructor loaded ");
	}

	//=======================Orange HRM============================
	@Given("user searches Orange HRM employee information with {string} {string} {string} {string}")
	//   @Test
	public void useSearchesEmployeeDetails(String UserName, String UserRele, String EmpName, String EmpStatus) throws InterruptedException{
		
			if(homePage.searchSystemUserInOrangeHrm(UserName, UserRele, EmpName, EmpStatus)) {
			test.log(Status.PASS, "searchUserHomePageTest passed ");
			logger.info("****** searchUserHomePageTest passed  ");
		}
			else {
			test.log(Status.FAIL, "searchUserHomePageTest failed");
			logger.error("****** searchUserHomePageTest failed  ");}
		
		//		 TestRunner.extent.addTestRunnerOutput("ext TEST1  \r\n");
	}


}