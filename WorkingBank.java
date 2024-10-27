//Jack Moran
//Program 7

package program4C;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class WorkingBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Variables
		Random rdom = new Random();
		
		AccountStack<Checking> checkStk = new AccountStack<Checking>();
		
		AccountStack<Savings> saveStk = new AccountStack<Savings>();
		
		LinkedListQueue<Customer> custQ = new LinkedListQueue<Customer>();
		
		
		//Fill both Stacks
		for(int i = 0; i < 25; i++)
		{
			int accNum = rdom.nextInt(1000, 9999);
			int accNum2 = rdom.nextInt(1000, 9999);
			
			Checking temp = new Checking(accNum);
			Savings temp2 = new Savings(accNum2);
			
			checkStk.push(temp);
			saveStk.push(temp2);
		}
		
		//Fill customer Queue
		for (int j = 0; j < 10; j++)
		{
			
			int cusNum = rdom.nextInt(1000, 9999);
			Customer temp3 = new Customer();
			String name = "Name" + (j + 1);
			
			temp3.setName(name);
			temp3.setId(cusNum);
			custQ.enqueue(temp3);
		}
		
		//Apply accounts to customers and do transactions
		for(int l = 0; l < 30; l++)
		{
			//temp variables
			int amm = rdom.nextInt(-9999,9999);
			Customer temp4 = new Customer();
			temp4 = custQ.dequeue();
			Savings temp5 = new Savings();
			Checking temp6 = new Checking();
			
			//checks for checking account
			//if there is no checking account assign one and either withdraw an ammount or deposit from the assigned checking
			if(temp4.checkingEmpty())
			{
				temp6 = checkStk.pop();
				if (amm >= 0)
					{temp6.deposit(amm, temp4.getName());}
				else
					{temp6.withdraw(-amm, temp4.getName());}
				temp4.setAcc(temp6);
				amm = rdom.nextInt(-9999,9999);
			}
			
			//If there is a checking account either withdraw or deposit to this account
			else
			{
				if(amm >=0)
					{temp4.depositC(amm, temp4.getName());}
				else
					{temp4.withdrawC(-amm, temp4.getName());}
				amm = rdom.nextInt(-9999,9999);
			}
			
			//Checks for savings account
			//If there is no savings account assign one and either withdraw or deposit to this account
			if(temp4.savingEmpty())
			{
				temp5 = saveStk.pop();
				
				if(amm >= 0)
					{temp5.deposit(amm, temp4.getName());}
				else
					{temp5.withdraw(-amm, temp4.getName());}
				temp4.setAcc(temp5);
				amm = rdom.nextInt(-9999,9999);
			}
			
			//If there is a savings account either withdraw or deposit to this account
			else
			{
				if(amm >=0)
					{temp4.depositS(amm, temp4.getName());}
				else
					{temp4.withdrawS(-amm, temp4.getName());}
				amm = rdom.nextInt(-9999,9999);
			}
			
			//return the customer to the back of the queue
			custQ.enqueue(temp4);
		}
		
		//Write the customer objects to a file
		try
		{
		PrintWriter writer = new PrintWriter(new FileWriter("Customers and Accounts.txt"));
		while(custQ.isEmpty() != true)
		{
		Customer tempx = new Customer();
		tempx = custQ.dequeue();
		Checking tempxc = tempx.getChecking();
		Savings tempxs = tempx.getSavings();
		writer.println("Customer Name: " + tempx.getName());
		writer.println("Customer ID: " + tempx.getId());
		writer.println("Checking:");
		writer.println("\tChecking Num: " + tempxc.getNumber());
		writer.println("\tChecking Amount: " + tempxc.getAmount());
		writer.println("Savings:");
		writer.println("\tSavings Num: " + tempxs.getNumber());
		writer.println("\tSavings Amount: " + tempxs.getAmount());
		writer.println();
		
		}
		System.out.println("Customers and their accounts have been written to Customers and Accounts.txt");
		writer.close();
		}
		catch(FileNotFoundException e){}
		catch(IOException e) {}
	}

}
