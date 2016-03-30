package zad2;

import java.util.Collections;
import java.util.List;

public class FindMaxImpl implements FindMax {

	public Integer getMax(List<Integer> arr){  
		Integer max = Collections.max(arr);

		return max;  
	}
	
	public static void main(String args[]){
		System.out.println("Hello maven with FindMax Alghorithm!");
	}
}
