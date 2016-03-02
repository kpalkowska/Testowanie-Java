package Maven.Zadanie2;

import java.util.Random;

public class PsikusImpl implements Psikus {

	public Integer CyfroKrad(Integer liczba) {
		
		if(liczba.toString().length() == 1)
			return null;
		
		else {
			Random rand = new Random();
			int index = rand.nextInt(100) % liczba.toString().length();
			String napis = "";
			
			for(int i = 0; i < liczba.toString().length(); i++){
				if(i != index)
					napis = napis + liczba.toString().charAt(i);
			}
			return Integer.parseInt(napis);
		}
	}

	public Integer HultajChochla(Integer liczba) throws NieudanyPsikusException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer Nieksztaltek(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer Heheszki(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean Titit(Integer liczba_dziel) {
		// TODO Auto-generated method stub
		return false;
	}

}
