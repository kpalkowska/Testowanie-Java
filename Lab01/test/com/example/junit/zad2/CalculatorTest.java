package com.example.junit.zad2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.junit.zad2.Calculator;

public class CalculatorTest {

	private Calculator calc = new Calculator();
	
	@Test
	public void addCheck(){
		assertEquals(5, calc.add(3, 2));
	}
	
	@Test
	public void subCheck(){
		assertEquals(1, calc.sub(3, 2));
	}
	
	@Test
	public void multiCheck(){
		assertEquals(6, calc.multi(3, 2));
	}
	
	@Test
	public void divCheck(){
		assertEquals(2, calc.div(4, 2));
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
