package Maven.Zadanie2;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HeheszkiWyjatki {

	private Kontrakt psikus;
    private Integer liczba;

    public HeheszkiWyjatki(Integer liczba) {
        this.liczba = liczba;
    }
	
	@Before
	public void start() {
		psikus = new Kontrakt();
	}
	
	@Parameters
    public static Collection<Object[]> liczby() {
        return Arrays.asList(new Object[][] {{ -1 }, { -26 }, { 0 }, { -923 }});
    }
	
	@Test(expected=IllegalArgumentException.class)
	public void ArgumentToZeroLubLiczbaUjemna(){
		psikus.Heheszki(liczba);
	}
	
	@Test(expected=NullPointerException.class)
	public void ArgumentToNull(){
		psikus.Heheszki(null);
	}
	
	@After
	public void koniec() {
		psikus = null;
	}

}
