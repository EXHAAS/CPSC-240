import java.util.LinkedList;
/**
* 
* *CPSC-240
*I hereby declare upon my word of honor that I have neither given nor recieved
*unauthorized help on this work.
*
*  @author  Anthony Tompkins
*/

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
	public static BikePart searchBikePartList(LinkedList<BikePart> bPLinkedList, String bPNameOrNumber)
	{
		BikePart part = null;
 		
		for (BikePart currentPart : bPLinkedList) 
		
		{
			if (currentPart.getName().equals(bPNameOrNumber)) 
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
