import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
/**
*
*CPSC-240
*I hereby declare upon my word of honor that I have neither given nor recieved
*unauthorized help on this work.
*
*  @author  Anthony Tompkins
*/
public class ReadInventory 
{
/**
 * Method that compares the contents of the main warehouse file with the contents of an inventory file with their contents expressed
 * LinkedList<BikePart>. when an item from the inventory file is present in the warehouse file the warehouse file's version of said
 * item is updated with the price, sale, quantity data from the inventory files version. If the item is not found in the warehouse
 * file the item is add to the warehouse file LinkedList.
 * @param bikeLL This is a Linked<BikePart> that gets it contents from them main "warehouse.txt" file.
 * @param scnr reads user input for file path.
 * @return returns the updated LinkedList.
 * @throws IOException
 */	
	public static LinkedList<BikePart> readInventory(LinkedList<BikePart> bikeLL, Scanner scnr) throws IOException
	{
		System.out.println("Input file path");
		String inventoryFileName = scnr.next();

		LinkedList<BikePart> inventoryLL = Importer.Import(inventoryFileName,1);
		Boolean notPresent = true;
		for(BikePart iBP: inventoryLL) 
		{
			for(BikePart wBP: bikeLL)
			{
				notPresent = true;
				if(wBP.getNumber().equals(iBP.getNumber()))
				{
					wBP.setListPrice(iBP.getListPrice());
					wBP.setSalesPrice(iBP.getSalesPrice());
					wBP.setOnSale(iBP.getOnSale());
					wBP.setQuantity(wBP.getQuantity() + iBP.getQuantity());
					notPresent = false;
					break;
				}
			}
			if(notPresent) 
			{
				bikeLL.add(iBP);
				
			}
		}
		
		
		return bikeLL;
	}
	
	
}
	
	
	

	
	
	
	
	
