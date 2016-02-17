package com.example.junit.zad5;

public class LiczbaRzymska {

	private int liczba;
	
	public LiczbaRzymska(int liczba){
		this.liczba = liczba;
	}
	
	public String toString(int liczba){
		
        if(liczba < 1 || liczba > 3999){
            return "-1";
        }
 
        int[] arabskie = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rzymskie = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String rzymska = "";
 
        for(int i=0; i<arabskie.length; i++){
            while(liczba >= arabskie[i]){
                rzymska += rzymskie[i];
                liczba -= arabskie[i];
            }
        }
 
        return rzymska;
	}
}
