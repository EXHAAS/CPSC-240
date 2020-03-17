import java.io.IOException;
import java.util.LinkedList;

/**
* 
* *CPSC-240
*I hereby declare upon my word of honor that I have neither given nor recieved
*unauthorized help on this work.
*
*  @author  Anthony Tompkins
*/
public class SearchBikePartList
{
/**
 *
 *This is a method that takes a LinkedList of BikePart objects and a name or number corresponding to the name or number field of 
 *a BikePart in the given LinkedList. It iterates through the LinkedList and returns the BikePart whos's part name or number field 
 *is equal to the given string.
 *
 * @param bPLinkedList This parameter is the LinkedList that is being searched through.
 * @param bPNameOrNumber This parameter is the part number or name of the BikePart that is being looked for.
 * @return Returns BikePart named "part".
 */
	//public static searchBikePartList(bPLinkedList:LinkedList<BikePart>,bPNameOrNumber:String ):BikePart
	public static BikePart searchBikePartList(LinkedList<BikePart> bPLinkedList, String bPNameOrNumber)
	{
		BikePart part = null;
 		
		for (BikePart currentPart : bPLinkedList) 
		
		{
			if (currentPart.getName().equalsIgnoreCase(bPNameOrNumber)) 
			{
				 part = currentPart;
			}
			else if (currentPart.getNumber().equals(bPNameOrNumber)) 
			{
				 part = currentPart;
			}

					
				
			
		}
		return part;
  } 
/**
 * A second implementation of the searchBikePartList method used for searching through
 * and updating the total inventory file.
 * @param bPLL a BikePart LinkedList derived from the totalinventory.txt file.
 * @param naNu a string of the name or part number of a BikePart.
 * @param otherInv The name of inventory file that the totalinventory.txt file is be compared to.
 * @param quantity Holds the quantity of value from a BikePart that is being entered.
 * @param state An integer that determines the exact behavior of the method.
 * @return A BikePart LinkedList is returned.
 * @throws IOException
 */
	public static LinkedList<BikePart> searchBikePartList(LinkedList<BikePart> bPLL, String naNu, String otherInv, int quantity, int state) throws IOException{
		
		int check = 0;
 		LinkedList<BikePart> otherInvLL = Importer.Import(otherInv, 1);
 		BikePart otherBP = searchBikePartList(otherInvLL, naNu);
		
 		for (BikePart currentPart : bPLL) 
		{
			if(state==0) {
 			if (currentPart.getName().equalsIgnoreCase(naNu)) 
			{
				int nq = currentPart.getQuantity() + quantity;
				currentPart.setQuantity(nq);
				check++; 
				
				
			}
			else if (currentPart.getNumber().equals(naNu)) 
			{
				int nq = currentPart.getQuantity() + quantity;
				currentPart.setQuantity(nq);
				check++;
				
			}
		
		
	    }
			else if(state == 1)
			{
				if(currentPart.getName().equalsIgnoreCase(otherBP.getName())){
					int nq = currentPart.getQuantity() - 1;
					currentPart.setQuantity(nq);
				}
			}
	
		}
 		if(state==0) {
 		if(check==0) {
			bPLL.add(otherBP);
			return bPLL;
		}
 		}
		return bPLL;
}}
