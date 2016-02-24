package zad1;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CalculatorTest {

	private Calculator calc = new Calculator();
	
	@Test
	public void addCheck(){
		int result = calc.add(3, 2);
		assertThat(result, is(5));
	}
	
	@Test
	public void subCheck(){
		int result = calc.sub(3, 2);
		assertThat(result, is(1));
	}
	
	@Test
	public void multiCheck(){
		int result = calc.multi(3, 2);
		assertThat(result, is(6));
	}
	
	@Test
	public void divCheck(){
		int result = calc.div(4, 2);
		assertThat(result, is(2));
	}
	
	@Test
	public void greaterCheck(){
		assertTrue(calc.greater(3, 2));
		assertFalse(calc.greater(2, 3));
	}
	
	@Test(expected = ArithmeticException.class)
	public void zeroCheck(){
		calc.div(1, 0);
	}
}
