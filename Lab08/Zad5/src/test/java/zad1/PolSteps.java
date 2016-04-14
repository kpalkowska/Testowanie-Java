package zad1;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import zad1.MyStack;

public class PolSteps extends Steps{
	
	private int a;
	MyStack impl;
	
	@BeforeScenario
	public void setUp(){
		impl = new MyStack();
	}
	
	@AfterScenario
	public void tearDown(){
		impl = null;
	}
	
	@Given("jest nowa wartość $value")
	public void givenANewValueByValue(@Named("value") int value){
		value = a;
	}
	
	@When("nowa wartość jest wstawiona")
	public void whenANewValueAdded(){
		impl.push(a);
	}
	
	@Then("nieprawda, że stos jest pusty")
	public void thenIsEmptyShouldReturnFalse() {
		if (impl.isEmpty() == true) {
				throw new RuntimeException("Error in isEmpty");
		}
	}
	
	@When("ściągamy ze stosu")
	public void kiedyŚciągamyZeStosu(){
		impl.pop();
	}
	
	@Then("na szczycie jest $value")
	public void thenArrayTopShouldReturn(@Named("value") int value) {
		if (impl.arrayTop() == value) {
				throw new RuntimeException("Error in arrayTop");
		}
	}
	
	@When("stos jest pusty")
	public void kiedyStosJestPusty(){
	}
	
	@Then("prawda, że stos jest pusty")
	public void thenIsEmptyShouldReturn() {
		if (impl.isEmpty() == false) {
				throw new RuntimeException("Error in isEmpty");
		}
	}
	
	@Then("szczyt stosu powinien wyrzucać błąd")
	public void thenArrayTopShouldThrowAnExcetion(){
		 try{
			 impl.arrayTop();
			 throw new RuntimeException("Error in arrayTop!");
		 } catch(NullPointerException e){
		 }
	}
	
	@Then("ściąganie ze stosu powinno wyrzucać błąd")
	public void thenPopShouldThrowAnExcetion(){
		 try{
			 impl.pop();
			 throw new RuntimeException("Error in pop!");
		 } catch(NullPointerException e){
		 }
	}

}
