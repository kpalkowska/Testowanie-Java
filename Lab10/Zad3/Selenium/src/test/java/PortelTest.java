import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortelTest {
	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void addsPage(){
		
		HomePage home = new HomePage(driver);
		home.clickOnAddsLink();
		home.setKeysToSearch();
		String actual = home.isInformation();
		
		Assert.assertEquals("Nie znaleziono og³oszeñ spe³niaj¹cych zadane kryteria", actual);
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
