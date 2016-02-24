package zad2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MyStackTest {
	
	private MyStack arr;
	
	@Before
	public void setup(){
		arr = new MyStack(5);
	}

	@Test
	public void myPushTest() {
		arr.myPush(1);
		int result = arr.tab[0];
		assertThat(result, is(1));
	}
	
	@Test
	public void myPopTest() {
		arr.myPush(1);
		arr.myPop();
		int result = arr.top;
		assertThat(result, is(-1));
	}
	
	@Test
	public void myTopTest() {
		arr.myPush(2);
		arr.myPush(1);
		int result = arr.myTop();
		assertThat(result, is(1));
	}
	
	@Test
	public void isEmptyTest(){
		boolean result = arr.isEmpty();
		assertTrue(result);
	}
	
	@Test
	public void notEmptyTest(){
		arr.myPush(1);
		boolean result = arr.isEmpty();
		assertFalse(result);
	}
	
	@After
	public void teardown(){
		arr = null;
	}

}
