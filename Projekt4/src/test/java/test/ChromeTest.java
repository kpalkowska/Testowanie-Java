package test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/admin/workspace/Selenium/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
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
		
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.urlToBe("https://books1.herokuapp.com/users/1"));
        String title = driver.getTitle();
		projekt.logout();
		wait.until(ExpectedConditions.urlToBe("https://books1.herokuapp.com/"));
		
		Assert.assertEquals("Klaudia | Books App", title);
	}
	
	//@Test
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
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.urlToBe("https://books1.herokuapp.com/users/1"));
		projekt.createBook();
		
		wait.until(ExpectedConditions.visibilityOf(projekt.backBtn));
		projekt.clickBack();
		
		wait.until(ExpectedConditions.elementToBeClickable(projekt.lastPage));
		String title = driver.getTitle();
		projekt.logout();
		wait.until(ExpectedConditions.urlToBe("https://books1.herokuapp.com/"));
		
		Assert.assertEquals("Index | Books App", title);
	}
	
	@Test
	public void CreateEmptyTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.urlToBe("https://books1.herokuapp.com/users/1"));
		projekt.createEmptyBook();
		
        wait.until(ExpectedConditions.visibilityOf(projekt.emptyError));
		String name = projekt.emptyError();
		projekt.logout();
		wait.until(ExpectedConditions.urlToBe("https://books1.herokuapp.com/"));
		
		Assert.assertEquals("The form contains 9 errors.", name);
	}
	
	//@Test
	public void DeleteTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.urlToBe("https://books1.herokuapp.com/users/1"));

		projekt.deleteBook();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		String info = projekt.infoBook();
		projekt.logout();
		wait.until(ExpectedConditions.urlToBe("https://books1.herokuapp.com/"));
		
		Assert.assertEquals("Book was successfully destroyed.", info);
	}
	
	//@Test
	public void UpdateTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.urlToBe("https://books1.herokuapp.com/users/1"));
		
		projekt.editBook();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		String info = projekt.updateTitle();
		projekt.logout();
		wait.until(ExpectedConditions.urlToBe("https://books1.herokuapp.com/"));
		
		Assert.assertEquals("Editing Book", info);
	}
	
	@Test
	public void ShowDetailsTest(){
		Projekt projekt = new Projekt(driver);
		projekt.login();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.urlToBe("https://books1.herokuapp.com/users/1"));
		projekt.showBook();
		
		String title = projekt.titleBook();
		projekt.logout();
		wait.until(ExpectedConditions.urlToBe("https://books1.herokuapp.com/"));
		
		Assert.assertEquals("Name: Dying of the Light", title);
	}
	
	@AfterClass
	public static void cleanp() {
		driver.close();
	}
}

