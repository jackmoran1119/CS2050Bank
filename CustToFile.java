package program4C;

import java.util.Random;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileNotFoundException;

public class CustToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rdom = new Random();
		
		AccountStack<Checking> checkStk = new AccountStack<Checking>();
		
		AccountStack<Savings> saveStk = new AccountStack<Savings>();
		
		LinkedListQueue<Customer> custQ = new LinkedListQueue<Customer>();
		
		for(int i = 0; i < 25; i++)
		{
			int accNum = rdom.nextInt(1000, 9999);
			int accNum2 = rdom.nextInt(1000, 9999);
			
			Checking temp = new Checking(accNum);
			Savings temp2 = new Savings(accNum2);
			
			checkStk.push(temp);
			saveStk.push(temp2);
		}
		
		for (int j = 0; j < 10; j++)
		{

			Customer temp3 = new Customer();
			int accT = rdom.nextInt(1,3);
			int rId = rdom.nextInt(1000,9999);
			String name = "Name" + (j + 1);
			
			if(accT == 1)
			{
				temp3.setChecking(checkStk.pop());
				temp3.setId(rId);
				temp3.setName(name);
			}
			if(accT == 2)
			{
				temp3.setSavings(saveStk.pop());
				temp3.setId(rId);
				temp3.setName(name);
			}
			
			custQ.enqueue(temp3);
			
			temp3.getInfo();
		}
		
		try
		{
		FileOutputStream cF = new FileOutputStream(new File("Customers.txt"));
		ObjectOutputStream cO = new ObjectOutputStream(cF);
		while(custQ.isEmpty() != true)
		{
		cO.writeObject(custQ.dequeue());
		}
		System.out.println("Customers have been serialized and written to Customers.txt");
		cO.close();
		cF.close();
		}
		catch(FileNotFoundException e){}
		catch(IOException e) {}
	}
}
