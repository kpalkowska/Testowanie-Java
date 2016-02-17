package com.example.junit.zad1;

import static org.junit.Assert.*;

import org.junit.Test;

public class EuklidesTest {

	private Euklides euk = new Euklides();
	
	@Test
	public void nwd(){
		assertEquals(1, euk.nwd(12, 1));
		assertEquals(12, euk.nwd(12, 12));
		assertEquals(6, euk.nwd(12, 18));
		assertEquals(18, euk.nwd(0, 18));
		assertEquals(12, euk.nwd(12, 0));
	}
	
	@Test(expected = ArithmeticException.class)
	public void zeroCheck(){
		euk.nwd(12, -12);
		euk.nwd(-12, 12);
		euk.nwd(0, 0);
	}
}
