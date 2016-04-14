package zad1;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

	private List<Integer> a;

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
		if (a.isEmpty()) {
			throw new NullPointerException();
		}
		a.remove((a.size()- 1));
    }

    public void push(int x)
    {
        a.add(x);
    }

    public int arrayTop()
    {
		if (a.isEmpty()) {
			throw new NullPointerException();
		}
		return a.get(a.size()-1);
    }
}
