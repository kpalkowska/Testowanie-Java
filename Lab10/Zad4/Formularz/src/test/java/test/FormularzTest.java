package test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FormularzTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void answerQuestions(){
		
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.onbeforeunload = function() {};"); 
		
		Formularz form = new Formularz(driver);
		form.selectSex();
		String selectedSex = form.isWoman();
		
		form.selectAnswer();
		String selectedAnswer = form.answer2();
		
		form.selectDuties();
		int selectedDuties = form.answer3();
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Assert.assertEquals("Kobieta", selectedSex);
		Assert.assertEquals("2-3 razy", selectedAnswer);
		Assert.assertEquals(3, selectedDuties);
		
		form.sendForm();
	}
	
	@Test
	public void badAnswerQuestions(){
		
		Formularz form = new Formularz(driver);
		form.selectTooMuchDuties();
		String tooMuch = form.getFourthError();
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Assert.assertEquals("Maksymalna wymagana liczba opcji: 3", tooMuch);
		
	}
	
	@Test
	public void sendingEmptyForm(){
		
		Formularz form = new Formularz(driver);
		form.sendForm();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		String e1 = form.getFirstError();
		String e2 = form.getSecondError();
		String e3 = form.getThirdError();
		
		Assert.assertEquals("Odpowiedü na to pytanie jest wymagana", e1);
		Assert.assertEquals("Odpowiedü na to pytanie jest wymagana", e2);
		Assert.assertEquals("Odpowiedü na to pytanie jest wymagana", e3);
	}

	@AfterClass
	public static void cleanp() {
		driver.close();
	}
}
