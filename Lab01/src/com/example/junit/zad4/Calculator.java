package com.example.junit.zad4;

public class Calculator {

	public Calculator(){
		System.out.println("Calculator: "+ this);
	}

	public double add(double n1, double n2){
		return n1 + n2;
	}
	
	public double sub(double n1, double n2){
		return n1 - n2;
	}
	
	public double multi(double n1, double n2){
		return n1 * n2;
	}
	
	public double div(double n1, double n2){
		return n1 / n2;
	}
	
	public boolean greater(double n1, double n2){
		if (n1 > n2)
			return true;
		else return false;
	}
	
}
