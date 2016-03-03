package Maven.Zadanie2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CyfroKradTest {
	
	private Kontrakt psikus;
	
	@Before
	public void start() {
		psikus = new Kontrakt();
	}
	
	@Test
	public void ArgumentToLiczbaDodatnia(){
		assertThat(psikus.CyfroKrad(123), anyOf(equalTo(12), equalTo(23), equalTo(13)));
		assertThat(psikus.CyfroKrad(10), either(is(1)).or(is(0)));
	}
	
	@Test
	public void ArgumentToLiczbaUjemna(){
		assertThat(psikus.CyfroKrad(-10), either(is(-1)).or(is(0)));
		assertThat(psikus.CyfroKrad(-19), either(is(-1)).or(is(-9)));
		assertThat(psikus.CyfroKrad(-22), is(-2));
	}
	
	@Test
	public void ArgumentToLiczbaJednocyfrowa(){
		assertNull(psikus.CyfroKrad(-1));
		assertNull(psikus.CyfroKrad(0));
	}
	
	@After
	public void koniec() {
		psikus = null;
	}

}
