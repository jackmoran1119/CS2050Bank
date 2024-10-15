//Jack Moran

//Program 6

package program4C;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

public class CustToFile2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Random rdom = new Random();
		
		LinkedListQueue<Customer> custQ = new LinkedListQueue<Customer>();
		
		
		for (int j = 0; j < 10; j++)
		{

			Customer temp3 = new Customer();
			int rId = rdom.nextInt(1000,9999);
			String name = "Name" + (j + 1);

			temp3.setId(rId);
			temp3.setName(name);

			
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
