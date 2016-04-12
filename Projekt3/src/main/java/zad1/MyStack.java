package zad1;

import java.util.ArrayList;

public class MyStack {

	private ArrayList<Integer> a;

    public MyStack()
    {
       a = new ArrayList<Integer>(); 
    }

    public boolean isEmpty()
    {
         return a.isEmpty();
    }

    public void pop()          
    {
    	if(a.size() != 0)
    		a.remove((a.size()- 1));
    	else
    		throw new IllegalArgumentException();
    }

    public void push(int x)
    {
        a.add(x);
    }

    public int arrayTop()
    {
    	if(a.size() != 0)
    		return(a.get(a.size() -1));
    	else
    		throw new IllegalArgumentException();
    }
}
