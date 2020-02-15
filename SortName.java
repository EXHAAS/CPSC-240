import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
 * Method to sort lines from the warehouseDB.txt file by name, and print out the sorted list.
 * 
 * @throws FileNotFoundException
 * @throws IOException
 */
	public static void sortName() throws FileNotFoundException, IOException 
	{
				
		BufferedReader warehouseBR = new BufferedReader(new FileReader("warehouseDB.txt"));
		List<String> warehouseList = new ArrayList<String>();
		String line;

// Loop where each line in "warehouseBR" is added to the ArrayList "warehouseList".
		while((line = warehouseBR.readLine()) != null) 
		{
		    warehouseList.add(line);
		}

// "warehouseList" is sorted alphabetically ignoring case.
		Collections.sort(warehouseList, String.CASE_INSENSITIVE_ORDER);

// Loop where every item in "warehouseList" is printed out.
// Items are broken up into Arrays, converted into Lists, and then printed. 
		for (String item : warehouseList) 
		 {
	       String[] itemArray = item.split(","); 
	       List<String> itemAsList = Arrays.asList(itemArray);
			System.out.println(itemAsList +"\n"); 
		 }
		warehouseBR.close();
	
	}

}
