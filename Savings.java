package program4C;

import java.io.Serializable;

class Savings extends Accounts implements Serializable
{
	
	private double interest;
	
	public Savings(double amo, int num, double interest)
	{
		super(amo, num);
		this.type = "Savings";
		this.interest = interest;
	}
	
	public Savings(int num)
	{
		super(num);
		setAmount(0);
		this.type = "Savings";
		this.interest = 1;
	}
	
	@Override
	public void showInfo()
	{
		System.out.println("This is a " + type + " Account");
		System.out.println("Account Number: " + getNumber());
		System.out.println("Ammount: " + "$" + getAmount());
	}
	
	public void setInterest(double interest)
	{
		this.interest = interest;
	}
	
	public double getInterest()
	{
		return interest;
	}
	

}
