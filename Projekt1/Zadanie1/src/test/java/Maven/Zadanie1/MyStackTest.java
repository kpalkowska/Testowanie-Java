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
	public void setUp() throws Exception {
		stack = new MyStack();
	}
	
	@Test
	public void myPushTest() {
		stack.push(1);
		int result = stack.arrayTop();
		assertThat(result, is(1));
	}
	
	@Test
	public void myPopTest() {
		stack.push(1);
		stack.pop();
		int result = stack.arrayTop();
		assertThat(result, is(-1));
	}
	
	@Test
	public void myTopTest() {
		stack.push(2);
		stack.push(1);
		int result = stack.arrayTop();
		assertThat(result, is(1));
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
	public void tearDown() throws Exception {
		stack = null;
	}

}
