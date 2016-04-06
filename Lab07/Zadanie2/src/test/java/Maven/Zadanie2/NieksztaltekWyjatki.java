package Maven.Zadanie2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NieksztaltekWyjatki {

	private Kontrakt psikus;
	
	@Before
	public void start() {
		psikus = new Kontrakt();
	}
	
	@Test(expected=NullPointerException.class)
	public void ArgumentToNull(){
		psikus.Nieksztaltek(null);
	}
	
	@After
	public void koniec() {
		psikus = null;
	}

}
