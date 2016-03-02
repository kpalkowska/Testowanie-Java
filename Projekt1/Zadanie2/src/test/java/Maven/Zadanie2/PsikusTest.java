package Maven.Zadanie2;

import static org.junit.Assert.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PsikusTest {

	Psikus psikus = new PsikusImpl();
	
	@Test
	public void cyfrokradKrad() {
		assertEquals(null, psikus.CyfroKrad(5));
		assertThat(psikus.CyfroKrad(123), anyOf(equalTo(12), equalTo(23), equalTo(13)));
		assertThat(psikus.CyfroKrad(10), either(is(1)).or(is(0)));
		assertNull(psikus.CyfroKrad(1));
	}

}
