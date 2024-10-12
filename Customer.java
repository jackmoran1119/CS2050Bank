package program4C;


import java.io.Serializable;
public class Customer implements Serializable {
	
	private String name;
	private int id;
	private Checking myChecking;
	private Savings mySavings;
	
	public Customer(String n, int i, Checking c, Savings s)
	{
		this.name = n;
		this.id = i;
		this.myChecking = c;
		this.mySavings = s;
	}
	
	public Customer(String n, int i, Checking c)
	{
		this.name = n;
		this.id = i;
		this.myChecking = c;
	}
	
	public Customer(String n, int i, Savings s)
	{
		this.name = n;
		this.id = i;
		this.mySavings = s;
	}
	
	public Customer(String n, int i)
	{
		this.name = n;
		this.id = i;
	}
	
	public Customer()
	{}
	
	public void setName(String n)
	{
		this.name = n;
	}

	public String getName()
	{
		return name;
	}
	
	public void setId(int i)
	{
		this.id = i;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setChecking(Checking c)
	{
		this.myChecking = c;
	}
	
	public Checking getChecking()
	{
		return myChecking;
	}
	
	public void setSavings(Savings s)
	{
		this.mySavings = s;
	}
	
	public Savings getSavings()
	{
		return mySavings;
	}
	
	public void getInfo()
	{
		System.out.println(name);
		System.out.println(id);
		
	    if (myChecking != null) {
	        System.out.println("Account Type: Checking");
	    }
	    
	    if (mySavings != null) {
	        System.out.println("Account Type: Savings");
	    }
	    
	    if (myChecking == null && mySavings == null) {
	        System.out.println("Account Type: None");
	    }

	}
}
