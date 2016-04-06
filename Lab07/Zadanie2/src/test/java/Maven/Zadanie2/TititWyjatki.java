package Maven.Zadanie2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TititWyjatki {

	private Kontrakt psikus;
	
	@Before
	public void start() {
		psikus = new Kontrakt();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ArgumentToZero(){
		psikus.Titit(0);
	}
	
	
	@Test(expected=NullPointerException.class)
	public void ArgumentToNull(){
		psikus.Titit(null);
	}
	
	@After
	public void koniec() {
		psikus = null;
	}
}
