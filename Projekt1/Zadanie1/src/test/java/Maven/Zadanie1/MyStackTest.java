package Maven.Zadanie1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {
	
	private MyStack stack;

	@Before
	public void setUp() {
		stack = new MyStack();
	}
	
	@Test
	public void pushAndTopTest() {
		stack.push(1);
		int result = stack.arrayTop();
		assertThat(result, is(1));
		
		assertThat(result, is(1));
		
		assertThat(result, is(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void arrayNullTest() {
		stack.arrayTop();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void popIfArrayIsNullTest() {
		stack.pop();
	}
	
	@Test
	public void popTest() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		int result = stack.arrayTop();
		assertThat(result, is(2));
	}
	
	@Test
	public void maxIntegerTest(){
		int max = Integer.MAX_VALUE;
		stack.push(max);
		assertEquals(max, stack.arrayTop());
	}
	
	@Test 
	public void minIntegerTest(){
		int min = Integer.MIN_VALUE;
		stack.push(min);
		assertEquals(min, stack.arrayTop());
	}
	
	@Test
	public void isEmptyTest(){
		boolean result = stack.isEmpty();
		assertTrue(result);
	}
	
	@Test
	public void notEmptyTest(){
		stack.push(1);
		boolean result = stack.isEmpty();
		assertFalse(result);
	}

	@After
	public void tearDown() {
		stack = null;
	}

}
