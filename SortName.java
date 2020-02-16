import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
*CPSC-240
*I hereby declare upon my word of honor that I have neither given nor received
*unauthorized help on this work.
*
*@author  Anthony Tompkins
*/
public class SortName 
{
/**
 * Method to sort BikePart info by name, and prints out the sorted list.
 * @param bPLList LinkedList of BikePart derived from the warehouseDB.txt file and any possible additions from other inventory files.
 * @throws FileNotFoundException
 * @throws IOException
 */
	public static void sortName(LinkedList<BikePart> bPLList) 
	{
				

		List<String> warehouseList = new ArrayList<String>();

// Loop where each BikePart in bPLList evokes the getInfo method, and the returned string is added to warehouseList.
		for(BikePart bP: bPLList) 
		{
		    warehouseList.add(bP.getInfo());
		}

// "warehouseList" is sorted lexicographically ignoring case.
		Collections.sort(warehouseList, String.CASE_INSENSITIVE_ORDER);

// Loop where every item in "warehouseList" is printed out.
// Items are broken up into Arrays, converted into Lists, and then printed. 
		for (String item : warehouseList) 
		 {
	       String[] itemArray = item.split(","); 
	       List<String> itemAsList = Arrays.asList(itemArray);
			System.out.println(itemAsList +"\n"); 
		 }

	
	}

}
