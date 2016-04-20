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

public class PortelTest {
	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/admin/workspace/Selenium/chromedriver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void homePage(){
		driver.get("http://www.portel.pl");
		element = driver.findElement(By.className("c8"));
		assertNotNull(element);
	}
	
	@Test
	public void addsPage(){
		driver.get("http://www.portel.pl");
		driver.findElement(By.className("c2")).click();
		driver.findElement(By.id("slw_in")).sendKeys("selenium");
		String actual = driver.findElement(By.id("wynikiDiv")).getText();
		
		Assert.assertEquals("Nie znaleziono og³oszeñ spe³niaj¹cych zadane kryteria", actual);
	}
	
	@Test
	public void naWynosPage(){
		driver.get("http://www.portel.pl/");
		driver.findElement(By.className("c8")).click();
		driver.findElement(By.id("tfNazwaDan")).sendKeys("pizza");
		driver.findElement(By.xpath(".//*[@class='buttonSubmit']")).click();

		Timeout.seconds(2);
        String actual = driver.findElement(By.className("naglowek")).getText();
        
        Assert.assertEquals("Lista dañ wyszukanych dla s³owa pizza", actual);
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("test/resources/polsat.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}
	
	@Test
	public void loginPage(){
		driver.get("http://www.portel.pl/mojportel.php");
        driver.findElement(By.id("tfLogin")).sendKeys("kp.elblag@wp.pl");
        driver.findElement(By.name("pass")).sendKeys("selenium2016");
        driver.findElement(By.xpath("//*[@id='content']/div/form/div/div[3]/button")).click();

        String actual = driver.findElement(By.xpath("//*[@id='content']/div[1]")).getText();

        Assert.assertEquals("Jesteœ zalogowany jako kp.elblag ( kp.elblag@wp.pl )", actual);
	}
	
	@Test
	public void badLoginPage(){
		driver.get("http://www.portel.pl/mojportel.php");
        driver.findElement(By.id("tfLogin")).sendKeys("kp.elblag@wp.pl");
        driver.findElement(By.name("pass")).sendKeys("pizza");
        driver.findElement(By.xpath("//*[@id='content']/div/form/div/div[3]/button")).click();

        Timeout.seconds(3);
        String actual = driver.findElement(By.xpath("//*[@id='content']/div[1]")).getText();

        Assert.assertEquals("B³êdny e-mail lub has³o", actual);
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
