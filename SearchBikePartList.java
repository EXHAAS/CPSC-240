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
 *This is a method that takes a LinkedList of BikePart objects and a number corresponding to the number field of 
 *a BikePart in the given LinkedList. It iterates through the LinkedList and returns the BikePart whos's part number field 
 *is equal to the given string.
 *
 * @param bPLinkedList This parameter is the LinkedList that is being searched through.
 * @param bPNumber This parameter is the part number of the BikePart that is being looked for.
 * @return Returns BikePart named "part".
 */
	public static BikePart searchBikePartList(LinkedList<BikePart> bPLinkedList, String bPNumber)
	{
		BikePart part = null;
 		
		for (BikePart currentPart : bPLinkedList) 
		
		{
			if (currentPart.getNumber().equals(bPNumber)) 
			{
				 part = currentPart;
				
			}

		}
		return part;
  } 
