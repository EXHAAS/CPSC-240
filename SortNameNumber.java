import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
/**
*CPSC-240
*I hereby declare upon my word of honor that I have neither given nor received
*unauthorized help on this work.
*
*@author  Anthony Tompkins
*/
public class SortNameNumber 
{
/**
 * 
 * Method that displays contents from bike part inventory files by name or part number.
 * 
 * @param sortP String used to tell if sorting by name or part number.
 * @param scnr Scanner used to store user input.
 * @throws IOException
 */
	public static void sortNameNumber(String sortP, Scanner scnr) throws IOException 
	{
		LinkedList<BikePart> bikeLL = null;
		Boolean loop = true;
		
		while(loop == true)
		{
			System.out.println("Enter: \n\nMain- Sort main warehouse \nVan- Sort a sales van \nTotal- Sort total inventory \nQuit- Quit to main menu");		
			String fileChoice = scnr.next();
		
			fileChoice = fileChoice.toUpperCase();
		
			if(fileChoice.equals("MAIN")) 
			{
				String warehouseFileName = "mainwarehouse.txt";
				bikeLL = Importer.Import(warehouseFileName, 0);
			}
			else if(fileChoice.equals("VAN")) 
			{
				System.out.println("Enter name of sales van file: ");
				String van = scnr.next();
				bikeLL = Importer.Import(van, 1);
			}
			else if(fileChoice.equals("TOTAL")) 
			{
				String totalInventoryFileName = "warehouseDB.txt";
				bikeLL = Importer.Import(totalInventoryFileName, 0);
			}
			else if(fileChoice.equals("QUIT")) 
			{
				loop = false;
				break;
			}
			else 
			{
				System.out.println("Invalid choice");
			}
		   		
    		if(sortP.toUpperCase().equals("SORTNAME")) 
    		{    		
    			Collections.sort(bikeLL,new NameComparator());  
    		}
    		else 
    		{
    			Collections.sort(bikeLL, new NumberComparator());	
    		}
    		for(BikePart bP: bikeLL)
    		{  
    			System.out.println("________________________________________________________");
    			if(sortP.toUpperCase().equals("SORTNAME")) 
	    		{	    		
    				System.out.println(bP.getName() + ", " + bP.getNumber() + ", " + bP.getListPrice() + ", " + bP.getSalesPrice()
    				+ ", " + bP.getOnSale() + ", " + bP.getQuantity());	
	    		}
    			else 
    			{
    				System.out.println(bP.getNumber() + ", " + bP.getName() + ", " + bP.getListPrice() + ", " + bP.getSalesPrice()
    				+ ", " + bP.getOnSale() + ", " + bP.getQuantity());	
    			}
    		}
    		System.out.println("\n\n\n");

		}
	}
}