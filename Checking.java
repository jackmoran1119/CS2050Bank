package program4C;

//import program4C.ACCOUNT;

class Checking extends ACCOUNT
{
	private double minimum;
	public Checking(double amo, int num, double min)
	{
		super(amo, num);
		this.type = "Checking";
		this.minimum = min;
		
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
}