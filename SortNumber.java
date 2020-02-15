import java.io.BufferedReader;
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
public class SortNumber 
{
/**
 * 	method that take a list, swaps the first second elements' positions, converts the list to a string, and then returns it.
 * @param list List that holds strings.
 * @return returns list as a string.
 */	
	public static String swapString(List<String> list)
		{
		Collections.swap(list, 0, 1);
        String listString = list.toString();
		return listString;
		}
    
/**
 * 	Method that sorts lines in the "warehousDB.txt" file by part number, and then prints out the sorted lines.
 * @throws IOException
 */
	public static void sortNumber()throws IOException 
	    {
		
			BufferedReader warehouseBR = new BufferedReader(new FileReader("warehouseDB.txt"));
			List<String> warehouseStringArrayList = new ArrayList<String>();

			String line;

// Loop were each line in warehouseBR is added to warehouseStringArrayList.			
			while((line = warehouseBR.readLine()) != null) 
			{
				warehouseStringArrayList.add(line);
			}

			List<String> warehouseArrayList = new ArrayList<String>();

// Loop were each string in warehouseStringArrayList is split up into an Array.
// The Array is then converted into a List, and said List passed to the swapString method.
// The returned string is than added to the warehouseArrayList.
			for (String part : warehouseStringArrayList) 
			{
				String[] partArray = part.split(",");

				List<String>partList = Arrays.asList(partArray);
		
				warehouseArrayList.add(swapString(partList));
			}

// warehouseArrayList is sorted in lexicographical order.			
			Collections.sort(warehouseArrayList);		

// Loop were each item in warehouseArrayList printed out.
			for (String item : warehouseArrayList) 
			{
	            System.out.print( item +"\n\n"); 		
			}
			warehouseBR.close();
	    }
}
		