package com.example.webguidemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PortelSteps {
	
	private final Pages pages;

	public PortelSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on login page")
    public void userIsOnHomePage(){        
        pages.home().open();        
    }
 
    @When("user enter login and password")
    public void userSendKeysOnLoginLink(){        
        pages.home().findElement(By.id("tfLogin")).sendKeys("kp.elblag@wp.pl");
        pages.home().findElement(By.xpath("id('content')/div[1]/form/div[1]/div[2]/div[2]/input")).sendKeys("");
    }
    
    @When("user click login button")
    public void userClicksLoginBtn(){        
        pages.home().findElement(By.xpath("id('content')/div[1]/form/div[1]/div[3]/button")).click();
    }
    
    @Then("user is logged in")
    public void userIsLogged(){
    	String title = pages.home().findElement(By.xpath("id('content')/div[1]")).getText();
		Assert.assertEquals("Jesteœ zalogowany jako kp.elblag ( kp.elblag@wp.pl )", title);
		pages.home().findElement(By.xpath("id('content')/div[2]/div[3]/div")).click();
    }
    
    @When("user enter bad password")
    public void userSendBadKeysOnLoginLink(){        
        pages.home().findElement(By.id("tfLogin")).sendKeys("kp.elblag@wp.pl");
        pages.home().findElement(By.xpath("id('content')/div[1]/form/div[1]/div[2]/div[2]/input")).sendKeys("");
    }
    
    @Then("user is not logged in")
    public void userIsNotLogged(){
    	String title = pages.home().findElement(By.xpath("id('content')/div[1]")).getText();
		 if(!(title == "B³êdny e-mail lub has³o")){
			 throw new RuntimeException("Error in test!");
		 }
    }
    
}
