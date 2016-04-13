package zad;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

public class MySteps extends Steps {
	
	private double price;
	
	@Given("food")
	public void givenANewValueByValue(){ }
	
	@When("the {apple|tomato|desk} cost $value")
	@Alias("a new item is pushed")
	public void whenANewValueAdded(@Named("value") double value){
		value = price;
	}
	
	@Then("I am happy")
	public void thenIsEmptyShouldBeFalse() { }

}
