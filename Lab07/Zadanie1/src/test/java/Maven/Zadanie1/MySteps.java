package Maven.Zadanie1;

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
	
	@BeforeScenario
	public void setUp(){
		impl = new MyStack();
	}
	
	@AfterScenario
	public void tearDown(){
		impl = null;
	}

	@Given("a new value by $value")
	public void givenANewValueByValue(@Named("value") int value){
		a = value;
	}
	
	@When("a new value added")
	public void whenANewValueAdded(){
		impl.push(a);
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
	
	@When("the stack is empty")
	public void whenTheStackIsEmpty(){ }
	
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
			 impl.arrayTop();
			 throw new RuntimeException("Error in pop!");
		 } catch(IllegalArgumentException e){
		 }
	}
}
