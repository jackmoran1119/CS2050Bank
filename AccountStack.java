package program4C;

import java.util.ArrayList;
import java.io.Serializable;
public class AccountStack<T> implements Serializable {
	private ArrayList<T> list;
	
	public AccountStack()
	{
		list = new ArrayList<>();
	}
	
	public boolean isEmpty() 
	{
		return list.isEmpty();
	}
	
	public void push(T item) 
	{
		list.add(item);
	}
	
	public T pop() 
	{
		if (isEmpty()) 
		{
		throw new RuntimeException("Stack is empty");
		}
		return list.remove(list.size() - 1);
	}
	
	public T peek() 
	{
		if (isEmpty()) 
		{
		throw new RuntimeException("Stack is empty");
		}
		return list.get(list.size() - 1);
	}
	
	public int size() 
	{
		return list.size();
	}
}
