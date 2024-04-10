package zz_naveenTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoTest {
	public static void main(String args[]) throws InterruptedException {
		//include config file as well
		String url = "http://www.facebook.com";
		System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement linkCreateNewAc= driver.findElement(By.xpath("//a[contains(text(),'Create new account')]"));
		linkCreateNewAc.click();
		Thread.sleep(5000);
		WebElement edtFirstName=driver.findElement(By.name("firstname"));
		edtFirstName.sendKeys("myFN");
		WebElement edtLastName=driver.findElement(By.name("lastname"));
		edtLastName.sendKeys("myLN");
		WebElement ddlDay=driver.findElement(By.id("day"));
		WebElement ddlMonth=driver.findElement(By.id("month"));
		WebElement ddlYear=driver.findElement(By.id("year"));
		DemoTest.selectItem(ddlDay, "9");
		DemoTest.selectItem(ddlMonth, "Aug");
		DemoTest.selectItem(ddlYear, "1977");
		
//		Select day = new Select(ddlDay);
//		Select month= new Select(ddlMonth);
//		Select year= new Select(ddlYear);
//		day.selectByVisibleText("9");
//		month.selectByVisibleText("Aug");
//		year.selectByVisibleText("1977");
		
		driver.quit();
	}
    public static void selectItem(WebElement we ,String visibleText) {
    	Select day = new Select(we);
    	day.selectByVisibleText(visibleText);
     }
}
