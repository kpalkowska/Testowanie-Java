package Maven.Zadanie2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HultajChochla {

	private Kontrakt psikus;
	
	@Before
	public void start() {
		psikus = new Kontrakt();
	}
	
	@Test
	public void ArgumentToLiczbaDodatnia() throws NieudanyPsikusException{
		assertThat(psikus.HultajChochla(12), is(21));
		assertThat(psikus.HultajChochla(11), is(11));
		assertThat(psikus.HultajChochla(397), anyOf(is(793), is(937), is(379)));
	}
	
	@Test
	public void ArgumentToLiczbaUjemna() throws NieudanyPsikusException{
		assertThat(psikus.HultajChochla(-12), is(-21));
		assertThat(psikus.HultajChochla(-11), is(-11));
		assertThat(psikus.HultajChochla(-397), anyOf(is(-793), is(-937), is(-379)));
	}

	@After
	public void koniec() {
		psikus = null;
	}

}
