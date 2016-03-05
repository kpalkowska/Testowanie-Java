package Maven.Zadanie2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HeheszkiTest {

	private Kontrakt psikus;
	
	@Before
	public void start() {
		psikus = new Kontrakt();
	}
	
	@Test
	public void ArgumentToLiczbaDodatnia(){
		assertThat(psikus.Heheszki(39), lessThan(39));
		assertThat(psikus.Heheszki(39), greaterThanOrEqualTo(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ArgumentToLiczbaUjemna(){
		assertThat(psikus.Heheszki(-12), lessThan(-12));
		assertThat(psikus.Heheszki(-12), greaterThanOrEqualTo(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ArgumentToZero(){
		assertThat(psikus.Heheszki(0), lessThan(0));
		assertThat(psikus.Heheszki(0), greaterThanOrEqualTo(0));
	}

	@After
	public void koniec() {
		psikus = null;
	}
}