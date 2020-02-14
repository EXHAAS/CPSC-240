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
 *This is a method that takes a LinkedList of BikePart objects and a name corresponding to the name field of 
 *a BikePart in the given LinkedList. It iterates through the LinkedList and returns the BikePart whos's name field 
 *is equal to the given string.
 *
 * @param bPLinkedList This parameter is the LinkedList that is being searched through.
 * @param bPName This parameter is the name of the BikePart that is being looked for.
 * @return Returns BikePart named "part".
 */
	public static BikePart searchBikePartList(LinkedList<BikePart> bPLinkedList, String bPName)
	{
		BikePart part = null;
 		
		for (BikePart currentPart : bPLinkedList) 
		
		{
			String currentPartName = currentPart.getName();
			if (currentPartName.equals(bPName)) 
			{
				 part = currentPart;
				
			}

		}
		return part;
  } 
