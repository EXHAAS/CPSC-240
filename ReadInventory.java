import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
/**
*
*CPSC-240
*I hereby declare upon my word of honor that I have neither given nor received
*unauthorized help on this work.
*
*  @author  Anthony Tompkins
*/
public class ReadInventory 
{
/**
 * Method that compares the contents of the main warehouse file with the contents of an inventory file with their contents expressed
 * in LinkedLists of BikeParts. when an item from the inventory file is present in the warehouse file the warehouse file's version of said
 * item is updated with the price, sale, quantity data from the inventory files version. If the item is not found in the warehouse
 * file the item is add to the warehouse file LinkedList.
 * @param bikeLL This is a LinkedList of BikeParts that gets it contents from them main "warehouse.txt" file.
 * @param scnr reads user input for file path.
 * @return returns the updated LinkedList.
 * @throws IOException
 * 
 * 
 */	
	public static LinkedList<BikePart> readInventory(LinkedList<BikePart> bikeLL, Scanner scnr) throws IOException
	{
// A LinkedList that holds BikeParts is made from an inputted inventory file.		
		LinkedList<BikePart> inventoryLL;
		System.out.println("Input file path");
		String inventoryFileName = scnr.next();
// try/catch block checks if NumberFormatException is thrown if inventory file is improperly formatted.
		try 
		{
		inventoryLL = Importer.Import(inventoryFileName,1);
		}
		catch(java.lang.NumberFormatException e) 
		{
		System.out.println("Failed to read file \nInvalid formatting\n\n");		
		return bikeLL;
		}
// notPresent keeps track of whether or not an inventory BikePart is present in the warehouse LinkedList of BikeParts.		
		Boolean notPresent = true;
		for(BikePart iBP: inventoryLL) 
		{
// Loop where each BikePart in inventoryLL is checked to see if it's number value is equal to the number value of any BikePart in
// bikeLL, and if so the bikeLL listPrice, salesPrice, and onSale value are update to that of the inventoryLL BikePart.
// The quanity value of the inventoryLL BikePart is added to the bikeLL's quantity value.			
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
// If the inventoryLL BikePart number value is not found in bikeLL, the inventoryLL BikePart is added to bikeLL.						
			}
			if(notPresent) 
			{
				bikeLL.add(iBP);
				
			}
		}
		
		
		return bikeLL;
	}
	
	
}
	
	
	

	
	
	
	
	
