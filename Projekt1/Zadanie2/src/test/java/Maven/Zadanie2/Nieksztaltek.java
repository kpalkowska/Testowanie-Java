package Maven.Zadanie2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Nieksztaltek {

private Kontrakt psikus;
	
	@Before
	public void start() {
		psikus = new Kontrakt();
	}
	
	@Test
	public void ArgumentToLiczbaZCyframiDoZmiany(){
		assertThat(psikus.Nieksztaltek(37), either(is(31)).or(is(87)));
		assertThat(psikus.Nieksztaltek(367), either(is(867)).or(is(397)).or(is(361)));
	}
	
	@Test
	public void ArgumentToLiczbaZJednaCyfraDoZmiany(){
		assertThat(psikus.Nieksztaltek(700), equalTo(100));
		assertThat(psikus.Nieksztaltek(565), equalTo(595));
		assertThat(psikus.Nieksztaltek(6), equalTo(9));
	}
	
	@Test
	public void ArgumentToLiczbaBezCyfrDoZmiany(){
		assertThat(psikus.Nieksztaltek(5), equalTo(5));
		assertThat(psikus.Nieksztaltek(209), equalTo(209));
	}
	
	@After
	public void koniec() {
		psikus = null;
	}

}
