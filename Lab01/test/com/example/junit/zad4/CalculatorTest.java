package com.example.junit.zad4;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.junit.zad4.Calculator;

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
		assertFalse(calc.greater(2.9, 3.8));
	}
}
