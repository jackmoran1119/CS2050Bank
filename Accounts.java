package program4C;

import java.io.Serializable;
abstract class Accounts implements Serializable{
	
	private double amount;
	private int number;
	protected String type;
	
	public Accounts(double amo, int num)
	{
		this.amount = amo;
		this.number = num;
	}
	
	public Accounts(int num)
	{
		this.amount = 0;
		this.number = num;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setAmount(double amo)
	{
		this.amount = amo;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public void setNumber(int num)
	{
		this.number = num;
	}
	
	
	public void deposit(double am)
	{
		if(am > 0)
		{
			this.amount += am;
			System.out.println("You Deposited: " + am);
			System.out.println("New Amount: " + this.amount);
		}
		else
		{
			System.out.println("Unable to deposit negative values");
		}
	}
	
	public void withdraw(double am)
	{
		if(am > this.amount)
		{
			System.out.println("Insufficient Funds!");
		}
		else
		{
			this.amount -= am;
			System.out.println("You Withdrew: " + am);
			System.out.println("New Amount: " + this.amount);
		}
	}
	public abstract void showInfo();
}