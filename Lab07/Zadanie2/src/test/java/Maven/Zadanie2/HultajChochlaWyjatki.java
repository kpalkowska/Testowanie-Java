package Maven.Zadanie2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HultajChochlaWyjatki {

	private Kontrakt psikus;
	
	@Before
	public void start() {
		psikus = new Kontrakt();
	}
	
	
	@Test(expected= NieudanyPsikusException.class)
	public void ArgumentToLiczbaJednocyfrowa() throws NieudanyPsikusException{
		psikus.HultajChochla(1);
	}
	
	
	@Test(expected= NullPointerException.class)
	public void ArgumentToNull() throws NieudanyPsikusException{
		psikus.HultajChochla(null);
	}
	
	@After
	public void koniec() {
		psikus = null;
	}

}
