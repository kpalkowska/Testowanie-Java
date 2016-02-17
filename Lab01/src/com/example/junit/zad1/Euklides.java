package com.example.junit.zad1;

import org.junit.Test;

public class Euklides {

	public int nwd(int n1, int n2){
		if(n1 < 0 || n2 < 0){
			throw new ArithmeticException();
		}
		else if(n1 == 0)
			return n2;
		else if(n2 == 0)
			return n1;
		else{
			while(n1 != n2 ){
				if(n1 > n2)
					n1-=n2;
				else
					n2-=n1;
			}
		}
		return n1;
	}
}
