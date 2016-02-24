package zad2;

public class MyStack { 
	
	int size;
	int[] tab;
	int top;
	
	public MyStack(int s) {
		size = s;
	    tab = new int[size];
	    top = -1;
	}
	public void myPush(int j) {
	    tab[++top] = j;
	}
	public int myPop() {
	   return tab[top--];
	}
	public int myTop() {
	   return tab[top];
	}
	public boolean isEmpty() {
	   return (top == -1);
	}
}