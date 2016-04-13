package zad1;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

public class MySteps extends Steps{
	
	private int a;
	MyStack impl;
	
	@AfterScenario
	public void tearDown(){
		impl = null;
	}
	
	@AfterScenario(uponOutcome=AfterScenario.Outcome.SUCCESS)
	public void afterSuccessfulScenario() {
	    System.out.print("Zakończono sukcesem");
	}
	     
	@AfterScenario(uponOutcome=AfterScenario.Outcome.FAILURE)
	public void afterFailedScenario() {
		System.out.print("Zakończono błędem");
	}
	
	@Given("the empty stack")
	public void givenTheEmptyStack() {
		impl = new MyStack();
	}

	@Then("isEmpty should be true")
	public void thenIsEmptyShouldBeTrue() {
		if (impl.isEmpty() == false) {
				throw new RuntimeException("Error in isEmpty");
		}
	}
	
	@Then("arrayTop should throw an exception")
	public void thenArrayTopShouldThrowAnExcetion(){
		 try{
			 impl.arrayTop();
			 throw new RuntimeException("Error in arrayTop!");
		 } catch(IllegalArgumentException e){
		 }
	}
	
	@Then("pop should throw an exception")
	public void thenPopShouldThrowAnExcetion(){
		 try{
			 impl.pop();
			 throw new RuntimeException("Error in pop!");
		 } catch(IllegalArgumentException e){
		 }
	}

	@Given("a new value by $value")
	public void givenANewValueByValue(@Named("value") int value){
		a = value;
	}
	
	@When("a new value pushed")
	public void whenANewValueAdded(){
		impl.push(a);
	}
	
	@Then("isEmpty should be false")
	public void thenIsEmptyShouldBeFalse() {
		if (impl.isEmpty() == true) {
				throw new RuntimeException("Error in isEmpty");
		}
	}
	
	@When("pop from the stack")
	public void whenPop(){
		impl.pop();
	}
	
	@Then("arrayTop should $value")
	public void thenArrayTopShouldBeEqual(@Named("value") int value){
		 if(impl.arrayTop() != value){
			 throw new RuntimeException("Error in test!");
		 }
	}
}
