package TestCase;

//import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import wppool.DriverSetup;

@Test
public class testWpDarkMood extends DriverSetup {

	// public static void main(String[] args) {

	public static String url = ("https://demosite860.wordpress.com/wp-admin");

	@Test
	public static void wppool() throws InterruptedException, IOException {

		String command = "openvpn --config /wppool/SaturnVPN_Config/uk2.saturnvpn.com.tcp.ovpn";

		ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
		Process process = processBuilder.start();

		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(8000);

		// Scenario 1: Log in to your WordPress site

		driver.findElement(By.id("user_login")).sendKeys("psubrun14@gmail.com");

		driver.findElement(By.id("user_pass")).sendKeys("1234567890*Aa");

		driver.findElement(By.id("wp-submit")).click();

		// Scenario 2: Check whether the "WP Dark Mode" Plugin is Active or not

		boolean isPluginActive = driver.findElements(By.linkText("WP Dark Mode")).size() > 0;

		if (!isPluginActive) {
			// Scenario 3: If not Active, Install the Plugin and Activate it
			WebElement plugins = driver.findElement(By.linkText("Plugins"));
			plugins.click();

			WebElement searchBox = driver.findElement(By.id("search-component-search-2"));
			searchBox.sendKeys("WP Dark Mode");

			driver.findElement(By.id("//button[@aria-label='Open Search']//*[name()='svg']")).click();

			// We need to upgrade to a Business Plan to install plugins
			driver.findElement(By.xpath("//button[normalize-space()='Purchase and activate']")).click();

			// Activate the plugin after installation
			driver.findElement(By.linkText("Activate Plugin")).click();
		}

		// Scenario 4: Enable Backend Darkmode from Settings -> General Settings
		driver.findElement(By.linkText("Settings")).click();

		driver.findElement(By.linkText("General")).click();


		WebElement Checkbox = driver.findElement(By.linkText("Backend Darkmode Checkbox"));
		if (!Checkbox.isSelected()) {
			Checkbox.click();
		}

		// Scenario 5: Validate whether the Darkmode is working on the Admin Dashboard

		WebElement darkModeToggle = driver.findElement(By.id("dark-mode-toggle"));
		darkModeToggle.click();

		WebElement darkModeIndicator = driver.findElement(By.linkText("WPDarkMode"));

		Assert.assertTrue(darkModeIndicator.isDisplayed());

		// Scenario 6: Navigate to the WP Dark Mode
		driver.findElement(By.linkText("Dashboard")).click();

		// Scenario 7: From Settings -> Switch Settings - Change the "Floating Switch
		// Style"
		driver.findElement(By.linkText("WP Dark Mode")).click();

		driver.findElement(By.linkText("Switch Settings")).click();

		driver.findElement(By.linkText("Floating Switch Style"));

		// Scenario 8: From Settings -> Switch Settings - Select Custom Switch size &
		// Scale it to 220
		driver.findElement(By.linkText("Custom Switch Size")).click();

		WebElement ScaleSwitchSize = driver.findElement(By.linkText("Custom Switch Size Input"));
		ScaleSwitchSize.clear();
		ScaleSwitchSize.sendKeys("220");

		// Scenario 9: From Settings -> Switch Settings - Change the Floating Switch
		// Position (Left Bottom)
		driver.findElement(By.linkText("Floating Switch Position"));

		// Scenario 10: Disable Keyboard Shortcut from the Accessibility Settings
		driver.findElement(By.linkText("Accessibility")).click();

		WebElement ShortcutCheckbox = driver.findElement(By.linkText("Shortcut Checkbox"));
		if (ShortcutCheckbox.isSelected()) {
			ShortcutCheckbox.click();
		}

		// Scenario 11: From Settings -> Animation - Enable "Darkmode Toggle Animation"
		// & change the "Animation Effect"
		driver.findElement(By.linkText("Animation")).click();

		WebElement Checkbox1 = driver.findElement(By.linkText("Toggle Animation Checkbox"));
		if (!Checkbox1.isSelected()) {
			Checkbox1.click();
		}

		WebElement animationEffectDropdown = driver.findElement(By.linkText("Animation Effect"));

		// Scenario 12: Validate whether the Darkmode is working from the Frontend
		WebElement elementToCheck = driver.findElement(By.cssSelector(".dark-mode-text"));

		String textColor = elementToCheck.getCssValue("color");

		String hexColor = Color.fromString(textColor).asHex();

		Assert.assertEquals(hexColor, "#ffffff", "Dark mode is not working from the Frontend");

		// Close the browser
		driver.quit();

		// Close the VPN connection when done
		process.destroy();

	}
}
