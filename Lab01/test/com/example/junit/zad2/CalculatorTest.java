package com.example.junit.zad2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.example.junit.zad2.Calculator;

public class CalculatorTest {

private Calculator calc = new Calculator();
private static final double DELTA = 1e-15;
	
	@Test
	public void addCheck(){
		assertEquals(5.12, calc.add(3.1, 2.02), DELTA);
	}
	
	@Test
	public void subCheck(){
		assertEquals(1.01, calc.sub(3.13, 2.12), DELTA);
	}
	
	@Test
	public void multiCheck(){
		assertEquals(6, calc.multi(3, 2), DELTA);
	}
	
	@Test
	public void divCheck(){
		assertEquals(2, calc.div(4.24, 2.12), DELTA);
	}
	
	@Test
	public void greaterCheck(){
		assertTrue(calc.greater(3.8, 2.9));
	}
	
	@Test
	public void zeroCheck(){
		try{
			calc.div(1.13, 0);
			fail("Nie można dzielić przez 0");
			
		} catch(ArithmeticException ex){
			
		}
	}
}
