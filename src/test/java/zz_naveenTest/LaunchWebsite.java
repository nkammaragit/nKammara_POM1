package zz_naveenTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.letzAutomate.qa.util.Constants;

public class LaunchWebsite {
	
	public static void main(String args[]) throws InterruptedException {
	
		System.getProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGELOAD_TIMEOUT));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		WebElement edtLogin= driver.findElement(By.name("username"));
		WebElement edtPassword= driver.findElement(By.name("password"));
		
		edtLogin.sendKeys("Admin");
		edtPassword.sendKeys("admin123");
		
		
	}

}
