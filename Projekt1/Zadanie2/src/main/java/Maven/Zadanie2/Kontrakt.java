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
			int indeks = rand.nextInt(100) % liczba.toString().length();
			String napis = "";
			
			if(indeks == 0 && liczba < 0)
				indeks++;
			
			for(int i = 0; i < liczba.toString().length(); i++){
				if(i != indeks)
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
		
		int znaleziono = 0;
		int iloscWystapien = 0;
		String nowaLiczba = "";
		
		for(int i = 0; i < liczba.toString().length(); i++){
			char c = liczba.toString().charAt(i);
			if(znaleziono == 0){
				if(c == '3'){
					nowaLiczba = nowaLiczba + '8';
					znaleziono = 1;
					iloscWystapien = 1;
				} else if (c == '7'){
					nowaLiczba = nowaLiczba + '1';
					znaleziono = 1;
					iloscWystapien = 1;
				} else if (c == '6') {
					nowaLiczba = nowaLiczba + '9';
					znaleziono = 1;
					iloscWystapien = 1;
				} else {
					nowaLiczba = nowaLiczba + c;
				}
			} else {
				nowaLiczba = nowaLiczba + c;
			}
		}
		
		return (iloscWystapien == 1) ? Integer.parseInt(nowaLiczba) : liczba;
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
