package program4C;

//import program4C.ACCOUNT;

class Savings extends ACCOUNT
{
	
	private double interest;
	
	public Savings(double amo, int num, double interest)
	{
		super(amo, num);
		this.type = "Savings";
		this.interest = interest;
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
