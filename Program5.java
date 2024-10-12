package program4C;

import java.util.Random;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileNotFoundException;


public class Program5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rdom = new Random();
		
		AccountStack<Checking> checkStk = new AccountStack<Checking>();
		
		AccountStack<Savings> saveStk = new AccountStack<Savings>();
		
		for(int i = 0; i < 25; i++)
		{
			int accNum = rdom.nextInt(1000, 9999);
			int accNum2 = rdom.nextInt(1000, 9999);
			
			Checking temp = new Checking(accNum);
			Savings temp2 = new Savings(accNum2);
			
			checkStk.push(temp);
			saveStk.push(temp2);
		}
		
		try
		{
		FileOutputStream cF = new FileOutputStream(new File("CheckingAccounts.txt"));
		ObjectOutputStream cO = new ObjectOutputStream(cF);
		while(checkStk.isEmpty() != true)
		{
		cO.writeObject(checkStk.pop());
		}
		System.out.println("Checking Accounts have been serialized and written to CheckingAccounts.txt");
		cO.close();
		cF.close();
		}
		catch(FileNotFoundException e){}
		catch(IOException e) {}
		
		try
		{
		FileOutputStream sF = new FileOutputStream(new File("SavingsAccounts.txt"));
		ObjectOutputStream sO = new ObjectOutputStream(sF);
		while(saveStk.isEmpty() != true)
		{
		sO.writeObject(saveStk.pop());
		}
		System.out.println("Savings Accounts have been serialized and written to SavingsAccounts.txt");
		sO.close();
		sF.close();
		}
		catch(FileNotFoundException e){}
		catch(IOException e) {}
		
		
		
		
	}

}
