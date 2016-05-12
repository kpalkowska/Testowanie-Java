package com.example.webguidemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailSteps extends Steps{
	
	private final Pages pages;
	
	String index;
	
	public EmailSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on interia page")
    public void userIsOnInteriaPage(){        
        pages.interia().open();     
    }
 
    @When("user enter interia login and password")
    public void userLoginToInteria(){        
        pages.interia().findElement(By.id("formEmail")).sendKeys("seleniumjava@interia.pl");
        pages.interia().findElement(By.id("formPassword")).sendKeys("");
        pages.interia().findElement(By.id("formSubmit")).click();
    }
    
    @Then("user is logged in interia")
    public void userIsLoggedInteria(){
    	String result = pages.interia().findElement(By.xpath("id('ng-app')/body/section[1]/div/div/header[2]/div[2]/div[1]")).getText();
        Assert.assertEquals("Test1", result);
    }
    
    @When("user enter bad interia login and password")
    public void userBadLoginToInteria(){        
        pages.interia().findElement(By.id("formEmail")).sendKeys("seleniumjava@interia.pl");
        pages.interia().findElement(By.id("formPassword")).sendKeys("123");
        pages.interia().findElement(By.id("formSubmit")).click();
    }
    
    @Then("user is not logged in interia")
    public void userIsNotLoggedInteria(){
    	String result = pages.interia().findElement(By.id("errorMsg")).getText();
        Assert.assertEquals("#1801 B³êdny login lub has³o", result);
        pages.interia().findElement(By.id("formEmail")).clear();
    }
    
    @When("user send email from interia")
    public void userSendEmail(){        
       	pages.interia().findElement(By.xpath("id('ng-app')/body/section[5]/section[1]/div/section/ul/li[1]/a")).click();
        pages.interia().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[1]/div[4]/div[3]/div/textarea")).sendKeys("seleniumjava@wp.pl");
        pages.interia().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[1]/div[4]/div[3]/div/textarea")).sendKeys(Keys.ENTER);
        
    	pages.interia().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[1]/div[5]/input")).sendKeys("Test");
        pages.interia().findElement(By.xpath("/html/body")).sendKeys("Test");
        
        pages.interia().findElement(By.xpath("id('ng-app')/body/div[1]/div/div[2]/div/div[3]/button[1]")).click();
    }
    
    @Then("email was send to wp")
    public void emailWasSend(){
        String result = pages.interia().findElement(By.xpath("id('ng-app')/body/div[2]/div/ul/li/div")).getText();
        Assert.assertEquals("Wiadomoœæ wys³ana", result);
    }
    
	@Given("user is on wp page")
    public void userIsOnWpPage(){        
        pages.wp().open();     
    }
    
    @When("user enter wp login and password")
    public void userLoginToWp(){        
        pages.wp().findElement(By.id("login")).sendKeys("seleniumjava@wp.pl");
        pages.wp().findElement(By.id("password")).sendKeys("");
        pages.wp().findElement(By.id("btnSubmit")).click();
    }
    
    @Then("user is logged in wp")
    public void userIsLoggedWp(){
    	String result = pages.wp().findElement(By.id("buttonName")).getText();
        Assert.assertEquals("seleniumjava@wp.pl", result);
    }
    
    @When("user receive email from interia")
    public void userReceiveEmail(){        
       	pages.wp().findElement(By.linkText("Odebrane")).click();
        pages.wp().findElement(By.xpath("id('bxMessagesBody')/div/div[6]/table/tbody/tr/td[6]/div")).click();
        pages.wp().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
        index = pages.wp().getWindowHandle();
    }
    
    @Then("email was received at wp")
    public void emailWasReceived(){
        String result = pages.wp().findElement(By.xpath("id('messageBody')/div/table/tbody/tr[1]/td/div/div[1]/div[2]/div[3]/div[1]/div[1]")).getText();
    	Assert.assertEquals("Test1", result);
    }
    
    @When("user answer email from wp")
    public void userAnswerEmail(){
       	pages.wp().findElement(By.xpath("id('messageBody')/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div/a[1]")).click();
       	
        for(String winHandle : pages.wp().getWindowHandles()){
            pages.wp().switchTo().window(winHandle);
          }
        
        String oldWindow = pages.wp().getWindowHandle();
        
       	pages.wp().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pages.wp().findElement(By.linkText("wstaw obrazek")).click();
       	
        for(String winHandle : pages.wp().getWindowHandles()){
            pages.wp().switchTo().window(winHandle);
          }
        
        pages.wp().findElement(By.xpath("id('imageUploadForm')/input[2]")).sendKeys("C:\\Users\\admin\\Desktop\\images.jpg");
       	pages.wp().findElement(By.xpath("id('imageUploadForm')/input[3]")).click();
       	
        pages.wp().switchTo().window(oldWindow);
    }
    
    @Then("email was send to interia")
    public void emailAnswer(){
    	pages.wp().findElement(By.xpath("id('newMail')/div/div/div/div/table[2]/tbody/tr/td/div/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr/td[1]/a")).click();

        String result = pages.wp().findElement(By.xpath("/html/body/div[3]/table/tbody/tr/td/div/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/div")).getText();
        Assert.assertEquals("Twoja wiadomoœæ zosta³a wys³ana", result);
        
        pages.wp().findElement(By.linkText("zamknij")).click();
    }
    
    @When("user deletes email")
    public void emailDelete(){
    	pages.wp().switchTo().window(index);
    	pages.wp().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pages.wp().findElement(By.linkText("usuñ")).click();
    }
    
    @Then("email is deleted")
    public void end(){
    	pages.wp().close();
    }
}
