package Maven.Zadanie2;

import java.util.Random;

public class Kontrakt implements Psikus {

	public Integer CyfroKrad(Integer liczba) {
		
		if(liczba >= 0 && liczba.toString().length() == 1)
			return null;
		
		else if(liczba < 0 && liczba.toString().length() == 2)
			return null;
		
		else {
			Random rand = new Random();
			int index = rand.nextInt(100) % liczba.toString().length();
			String napis = "";
			
			if(index == 0 && liczba < 0)
				index++;
			
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

		if(liczba > 0){
			Random rand = new Random();
			int nowa = rand.nextInt(liczba);
	
			return nowa;
		}
		else 
			throw new IllegalArgumentException();
	}

	public boolean Titit(Integer liczba_dziel) {

		int liczba = 120;
		if(liczba_dziel == 0)
			throw new IllegalArgumentException();
		else{
			if(liczba % liczba_dziel == 0)
				return true;
			else return false;
		}
	}

}
