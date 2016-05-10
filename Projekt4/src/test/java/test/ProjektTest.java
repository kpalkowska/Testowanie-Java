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
	public void SignUpTest(){
		Projekt projekt = new Projekt(driver);
		projekt.signUp();
		
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(projekt.signUpError));
		String error = projekt.signUpError();
		Assert.assertEquals("Email has already been taken", error);
	}
	
	@Test
	public void LoginTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		String title = driver.getTitle();
		
		projekt.logout();
		Assert.assertEquals("Klaudia | Books App", title);
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
		projekt.clickBack();
		projekt.lastPage();
		
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(projekt.addedName));
		String name = projekt.addedBook();
		
		projekt.logout();
		Assert.assertEquals("Test", name);
	}
	
	@Test
	public void CreateEmptyTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		projekt.createEmptyBook();
		
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(projekt.emptyError));
		String name = projekt.emptyError();
		
		projekt.logout();
		Assert.assertEquals("The form contains 9 errors.", name);
	}
	
	@Test
	public void DeleteTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		projekt.deleteBook();
		
        WebDriverWait wait = new WebDriverWait(driver, 15);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		String info = projekt.infoBook();
		
		projekt.logout();
		Assert.assertEquals("Book was successfully destroyed.", info);
	}
	
	@Test
	public void UpdateTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		projekt.editBook();
		
        WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.urlToBe("https://books1.herokuapp.com/books/3/edit"));

		String info = projekt.updateTitle();
		
		projekt.logout();
		Assert.assertEquals("Editing Book", info);
	}
	
	@Test
	public void ShowDetailsTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		projekt.showBook();
		
		String title = projekt.titleBook();
		
		projekt.logout();
		Assert.assertEquals("Name: Dying of the Light", title);
	}
	
	@AfterClass
	public static void cleanp() {
		driver.close();
	}
}
