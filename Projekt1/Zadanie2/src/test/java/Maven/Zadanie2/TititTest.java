package Maven.Zadanie2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TititTest {

	private Kontrakt psikus;
	
	@Before
	public void setUp() {
		psikus = new Kontrakt();
	}

	@Test
	public void ArgumentIsPositiveNumberTest(){
		assertThat(true, equalTo(psikus.Titit(5)));
		assertThat(false, equalTo(psikus.Titit(9)));
	}
	
	@Test
	public void ArgumentIsNegativeNumberTest(){
		assertThat(true, equalTo(psikus.Titit(-5)));
		assertThat(false, equalTo(psikus.Titit(-9)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ArgumentIsZeroTest(){
		psikus.Titit(0);
		fail("Illegal argument");
	}
	
	@After
	public void tearDown() {
		psikus = null;
	}

}
