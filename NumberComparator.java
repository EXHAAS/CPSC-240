
import java.util.Comparator;
/**
*CPSC-240
*I hereby declare upon my word of honor that I have neither given nor received
*unauthorized help on this work.
*@author  Anthony Tompkins
*
*
*Class that implements the Comparator interface that allows BikeParts to be compared with one another by their number field.
*/
public class NumberComparator implements Comparator<BikePart>
{
	public int compare(BikePart bP1, BikePart bP2) 
	{

		return (bP1.getNumber().compareToIgnoreCase(bP2.getNumber()));
		
	}
	
}