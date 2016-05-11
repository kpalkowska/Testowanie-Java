package com.example.webguidemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CalcSteps extends Steps{
	
	private final Pages pages;
	private String a;
	private String b;

	public CalcSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on calculator page")
    public void userIsOnHomePage(){        
        pages.home().open();        
    }
 
    @When("user enter tangent 180")
    public void userSendKeys(){        
        pages.home().findElement(By.id("Btn1")).click();
        pages.home().findElement(By.id("Btn8")).click();
        pages.home().findElement(By.id("Btn0")).click();
        pages.home().findElement(By.id("BtnTan")).click();
        pages.home().findElement(By.id("BtnCalc")).click();
    }
    
    @Then("result is 0")
    public void userClicksEqualsBtn(){
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        String result = pages.home().findElement(By.id("input")).getAttribute("value").toString();
        Assert.assertEquals("0", result);
        
        pages.home().findElement(By.id("input")).clear();
    }
    
    @When("user enter tangent <value>")
    public void userSendKeysParam(@Named("value") String value){        
        a = value;
        pages.home().findElement(By.id("input")).sendKeys(a);
        pages.home().findElement(By.id("BtnTan")).click();
        pages.home().findElement(By.id("BtnCalc")).click();
    }
    
    @Then("result is <result>")
    public void userClicksEqualsBtnParam(@Named("result") String value){
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	b = value;
        String result = pages.home().findElement(By.id("input")).getAttribute("value").toString();
        Assert.assertEquals(b, result);
        
        pages.home().findElement(By.id("input")).clear();
    }
}
