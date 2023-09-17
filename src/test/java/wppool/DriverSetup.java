package wppool;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverSetup {
	public static WebDriver driver;
	@BeforeSuite
	public static void openDriver() {
		// Set the path to the ChromeDriver executable
		//System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");

		
		System.setProperty("webdriver.Opera.driver", ".//operadriver.exe");
        WebDriver driver = new OperaDriver();
        
		// Initialize the WebDriver
		//driver = new ChromeDriver();
	}
	
	@AfterSuite
	public static void driverClose() {
		driver.close();
	}
}
