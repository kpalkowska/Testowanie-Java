package test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjektTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void LoginTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		
		Assert.assertEquals("Klaudia | Books App", driver.getTitle());
		projekt.logout();
	}
	
	@Test
	public void BadLoginTest(){
		Projekt projekt = new Projekt(driver);
		projekt.badLogin();
		
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(projekt.notLogged));
		String notLogged = projekt.notLogged();
		Assert.assertEquals("Invalid email or password", notLogged);
	}
	
	@Test
	public void CreateTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		projekt.createBook();
		
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(projekt.addedName));
		String name = projekt.addedBook();
		Assert.assertEquals("Test", name);
		projekt.logout();
	}
	
	@Test
	public void CreateEmptyTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		projekt.createEmptyBook();
		
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(projekt.emptyError));
		String name = projekt.emptyError();
		Assert.assertEquals("The form contains 9 errors.", name);
		projekt.logout();
	}
	
	@Test
	public void DeleteTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		projekt.deleteBook();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		alert.accept();
		
		String info = projekt.infoBook();
		Assert.assertEquals("Book was successfully destroyed.", info);
		projekt.logout();
	}
	
	@Test
	public void ShowDetailsTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		projekt.showBook();
		
		String title = projekt.titleBook();
		Assert.assertEquals("Name: Death Be Not Proud", title);
		projekt.logout();
	}
	
	@AfterClass
	public static void cleanp() {
		driver.close();
	}
}
