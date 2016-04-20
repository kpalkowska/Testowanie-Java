import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class AllegroTest {
	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void searchPage(){
		driver.get("http://www.allegro.pl");
		driver.findElement(By.id("main-search-text")).sendKeys("sukienka");
		driver.findElement(By.xpath("//*[@id='main-search']/input")).click();
		String actual = driver.findElement(By.xpath("//*[@id='wrapper']/header/h1")).getText();

		Assert.assertEquals("szukasz sukienka", actual);
	}
	
	@Test
	public void searchBadPage(){
		driver.get("http://www.allegro.pl");
		driver.findElement(By.id("main-search-text")).sendKeys("123lalala");
		driver.findElement(By.xpath("//*[@id='main-search']/input")).click();
		String actual = driver.findElement(By.xpath("//*[@id='listing']/div[3]/div/p[1]")).getText();

		Assert.assertEquals("Wygl¹da na to, ¿e nie mamy tego, czego szukasz.", actual);
	}
	
	@Test
	public void searchBadUrl(){
		driver.get("http://www.allegro.pl/xyz");
		String actual = driver.findElement(By.xpath("//div[2]/h1")).getText();
		
		Assert.assertEquals("B³¹d 404: Strona nie zosta³a znaleziona", actual);
	}
	
	@Test
	public void downloadPdf(){
		FirefoxProfile firefoxProfile = new FirefoxProfile();

		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
		firefoxProfile.setPreference("browser.download.dir", "c:\\tmp");
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

		firefoxProfile.setPreference("pdfjs.disabled", true);

		firefoxProfile.setPreference("plugin.scan.Acrobat", "99.0");
		firefoxProfile.setPreference("plugin.scan.plid.all", false);

		driver = new FirefoxDriver(firefoxProfile);
		
		driver.get("https://kupony.allegro.pl/citylight/regulamin.pdf");
	}
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
