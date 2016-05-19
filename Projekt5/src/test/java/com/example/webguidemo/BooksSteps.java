package com.example.webguidemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;

public class BooksSteps extends Steps{
	
	private final Pages pages;
	
	String index;
	String email;
	
	public BooksSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on home page")
    public void userIsOnInteriaPage(){        
        pages.books().open();     
    }
 
    @When("user enter login and password")
    public void userLoginToInteria(){
    	pages.books().findElement(By.xpath("/html/body/header/div/nav/ul/li[3]/a")).click();
        pages.books().findElement(By.id("session_email")).sendKeys("kp.elblag@wp.pl");
        pages.books().findElement(By.id("session_password")).sendKeys("123456");
        pages.books().findElement(By.xpath("/html/body/div/div/div/form/input[5]")).click();
    }
    
    @Then("user is logged in")
    public void userIsLoggedInteria(){
    	Assert.assertEquals("Klaudia | Books App", pages.books().getTitle());
    }
    
    @When("user add new book")
    public void userBadLoginToInteria(){        
        pages.books().findElement(By.id("logo")).click();
        pages.books().findElement(By.xpath("/html/body/div/a")).click();
        pages.books().findElement(By.id("book_name")).sendKeys("Test");
        pages.books().findElement(By.id("book_description")).sendKeys("Test");
        pages.books().findElement(By.id("book_price")).sendKeys("20.99");
        pages.books().findElement(By.id("book_author_id")).sendKeys("1");
        pages.books().findElement(By.id("book_img_url")).sendKeys("http://blog.zooplus.pl/wp-content/uploads/sites/8/2014/03/maly_kotek.jpg");
        pages.books().findElement(By.xpath("id('new_book')/div[6]/input")).click();
    }
    
    @Then("book was added")
    public void userIsNotLoggedInteria(){
    	pages.books().findElement(By.xpath("/html/body/div/a[2]")).click();
    	pages.books().findElement(By.xpath("/html/body/div/div/ul/li[13]/a")).click();
    	String result = pages.books().findElement(By.xpath("/html/body/div/table/tbody/tr[7]/td[1]")).getText();
        Assert.assertEquals("Test", result);
        
        pages.books().close();
    }
}
