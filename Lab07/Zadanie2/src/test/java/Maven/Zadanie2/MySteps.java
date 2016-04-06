package Maven.Zadanie2;

import java.util.ArrayList;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

public class MySteps extends Steps{
	
	private int a;
	Throwable t;
	Kontrakt kontrakt = new Kontrakt();
	
	@Given("a new numbers $value and $value2")
	public void givenANumberByValue(@Named("value") int value, @Named("value2") int value2){
		kontrakt = new Kontrakt(value);
		a = value2;
	}
	
	@Then("titit should $value")
	public void thenTititShouldBeEqual(@Named("value") boolean value){
		 if(kontrakt.Titit(a) != value){
			 throw new RuntimeException("Error in test!");
		 }
	}
	
	/*@Then("nieksztaltek should $value")
	public void thenNieksztaltekBeEqual(@Named("value") int value){
		 if(kontrakt.Nieksztaltek(a) != value){
			 throw new RuntimeException("Error in test!");
		 }
	}*/
	
	@When("second argument is 0")
	public void whenArgumentIsZero(){ }

	@Then("titit throw an IllegalArgumentException")
	public void thenTitit2ShouldThrowAnExcetion(){
		 try{
			 kontrakt.Titit(a);
		 } catch(IllegalArgumentException e){
			 t = e;
		 }
	}
	
	@When("argument is null")
	public void whenArgumentIsNull(){ }

	@Then("titit throw an NullPointerException")
	public void thenTititShouldThrowAnExcetion(){
		 try{
			 kontrakt.Titit(a);
		 } catch(NullPointerException e){
			 t = e;
		 }
	}
}
