package program4C;

import java.io.Serializable;

class Checking extends Accounts implements Serializable
{
	private double minimum;
	public Checking(double amo, int num, double min)
	{
		super(amo, num);
		this.type = "Checking";
		this.minimum = min;
		
	}
	
	public Checking(int num)
	{
		super(num);
		setAmount(0);
		this.type = "Checking";
		this.minimum = 0;
	}
	
	@Override
	public void showInfo()
	{
		System.out.println("This is a " + type + " Account");
		System.out.println("Account Number: " + getNumber());
		System.out.println("Ammount: " + "$" + getAmount());
	}
	
	public void setMinimum(double min)
	{
		this.minimum = min;
	}
	
	public double getMinimum()
	{
		return minimum;
	}
	
	@Override
	public void withdraw(double am)
	{
		if((getAmount() - am) < minimum)
		{
			System.out.println("Insufficient Funds!");
		}
		else
		{
			setAmount(getAmount() - am);
			System.out.println("You Withdrew: " + am);
			System.out.println("New Amount: " + getAmount());
		}
	}
	
	@Override
    public String toString() {
        return "Checking Account Number: " + getNumber();
    }
}