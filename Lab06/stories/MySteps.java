import java.util.List;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

import zad2.*;

public class MySteps extends Steps{

	private List<Integer> arr;
	FindMaxImpl impl = new FindMaxImpl();
	
	@Then("getMax should equal $value")
	public void thenGetMaxShouldBeEqual(@Named("value") Integer value){
		 if(impl.getMax(arr) != value){
			 throw new RuntimeException("Error in test!");
		 }
	}
	@Given("an array by $value")
	public void givenAnArrayByValue(@Named("value") List<Integer> value){
		arr = value;
	}

}