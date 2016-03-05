package Maven.Zadanie2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HultajChochlaTest {

	private Kontrakt psikus;
	
	@Before
	public void start() {
		psikus = new Kontrakt();
	}
	
	@Test
	public void ArgumentToLiczbaDodatnia(){
		
	}

	@After
	public void koniec() {
		psikus = null;
	}

}
