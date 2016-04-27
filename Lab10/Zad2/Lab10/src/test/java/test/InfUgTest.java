package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InfUgTest {
	
	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void MfiUgTest(){
		driver.get("http://www.inf.ug.edu.pl");
		driver.findElement(By.linkText("Wydzia³ MFI UG")).click();
		
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    
		Assert.assertEquals("Wydzia³ Matematyki, Fizyki i Informatyki", driver.getTitle());
		
	    driver.close();
	}
	
	@Test
	public void MfiUgSearchTest(){
		driver.get("http://www.inf.ug.edu.pl");
		driver.findElement(By.linkText("Wydzia³ MFI UG")).click();
		
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    
	    driver.findElement(By.id("edit-search-block-form--2")).sendKeys("dziekanat");
	    driver.findElement(By.id("edit-submit")).click();
	    driver.findElement(By.linkText("Przeprowadzka. Dziekanat nieczynny w dniach 23-27.07.2015")).click();

		Assert.assertEquals("Przeprowadzka. Dziekanat nieczynny w dniach 23-27.07.2015 | Wydzia³ Matematyki, Fizyki i Informatyki", driver.getTitle());
	}
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}

}
