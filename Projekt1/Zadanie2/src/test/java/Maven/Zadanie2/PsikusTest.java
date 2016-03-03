package Maven.Zadanie2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PsikusTest {

	Kontrakt psikus = new Kontrakt();
	private Integer input;
	private ArrayList<Integer> output = new ArrayList();
	
	@Test
	public void CyfroKradTest() {
		assertThat(psikus.CyfroKrad(123), anyOf(equalTo(12), equalTo(23), equalTo(13)));
		assertThat(psikus.CyfroKrad(10), either(is(1)).or(is(0)));
		assertNull(psikus.CyfroKrad(1));
	}
	
	@Test
	public void HeheszkiTest(){
		assertThat(psikus.Heheszki(39), lessThan(39));
		assertThat(psikus.Heheszki(39), greaterThanOrEqualTo(0));
	}

}
