package zad3;

public class Sortowanie {
	
	public void SortArray(Integer tablica[]){
		int temp;
		int zmiana = 1;
		
		while(zmiana > 0){
			zmiana = 0;
			for(int i=0; i<tablica.length-1; i++){
				if(tablica[i]>tablica[i+1]){
					temp = tablica[i+1];
					tablica[i+1] = tablica[i];
					tablica[i] = temp;
					zmiana++;
				}
			}
		}
	}
}
