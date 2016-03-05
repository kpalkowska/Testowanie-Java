package Maven.Zadanie2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TititTest {

	private Kontrakt psikus;
	
	@Before
	public void start() {
		psikus = new Kontrakt();
	}

	@Test
	public void ArgumentToLiczbaDodatnia(){
		assertThat(true, equalTo(psikus.Titit(5)));
		assertThat(false, equalTo(psikus.Titit(9)));
	}
	
	@Test
	public void ArgumentToLiczbaUjemna(){
		assertThat(true, equalTo(psikus.Titit(-5)));
		assertThat(false, equalTo(psikus.Titit(-9)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ArgumentToZero(){
		psikus.Titit(0);
	}
	
	@After
	public void koniec() {
		psikus = null;
	}

}
