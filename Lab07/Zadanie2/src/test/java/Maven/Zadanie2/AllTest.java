package Maven.Zadanie2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CyfroKrad.class, 
				CyfroKradWyjatki.class, 
				Heheszki.class, 
				HeheszkiWyjatki.class, 
				HultajChochla.class, 
				HultajChochlaWyjatki.class, 
				Nieksztaltek.class, 
				NieksztaltekWyjatki.class, 
				Titit.class,
				TititWyjatki.class })
public class AllTest {
  
}