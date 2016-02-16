package com.example.junit.zad3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LiczbaRzymskaTest {

	private int liczba;
	private LiczbaRzymska rzymska = new LiczbaRzymska(liczba);
	
	@Test
	public void rzymskieCheck(){
		assertEquals("V", rzymska.toString(5));
		assertEquals("XI", rzymska.toString(11));
		assertEquals("VII", rzymska.toString(7));
		assertEquals("I", rzymska.toString(1));
	}
	
	@Test
	public void ujemneCheck(){
		assertEquals("-1", rzymska.toString(-7));
	}
}
