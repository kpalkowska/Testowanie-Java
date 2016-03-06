package Maven.Zadanie2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Titit {

	private Kontrakt psikus;
    private Integer dzielna;
    private Integer liczba_dziel;
    private boolean wynik;

    public Titit(Integer dzielna, Integer liczba_dziel, boolean wynik) {
        this.dzielna = dzielna;
        this.liczba_dziel = liczba_dziel;
        this.wynik = wynik;
    }
	
	@Parameters
    public static Collection<Object[]> liczby() {
        return Arrays.asList(new Object[][] {{ 120, -5, true }, { 120, -9, false }, { 21, 7, true }, {-13, 2, false }});
    }

	@Test
	public void ArgumentToLiczbaDodatniaLubUjemna(){
		psikus = new Kontrakt(dzielna);
		assertThat(psikus.Titit(liczba_dziel), equalTo(wynik));
	}

	
	@After
	public void koniec() {
		psikus = null;
	}

}
