/*THE MAIN METHOD FOR PROJECT 1
*
*I hereby declare upon my word of honor that I have neither given nor recieved
*unauthorized help on this work
*
*@author Ellie Haas
*@author Hayden Webb
*@author Anthony Tompkins
*/
import java.util.Scanner;
import java.util.LinkedList;
import java.io.IOException;


public class MainMethod{
   
	public static void main(String[] args)throws IOException{
	  String warehouseFileName = "warehouseDB.txt";
	 LinkedList<BikePart> bikeLL = Importer.Import(warehouseFileName, 0);
	   
	  Scanner reader = new Scanner(System.in);
      boolean loop = true;
      
      while(loop == true){
//PRINT THE USERS CHOICES, THEN LET THEM ENTER THEIR CHOICE
         System.out.println("Please select your option from the following menu:");
         System.out.println("Read: Read an inventory delivery file");
         System.out.println("Enter: Enter a part");
         System.out.println("Sell: Sell a part");
         System.out.println("Display: Display a part");
         System.out.println("SortName: Sort parts by part name");
         System.out.println("SortNumber: Sort parts by part number");
         System.out.println("CreateVan: Create a new van for the fleet");
         System.out.println("Quit:");
         System.out.println("Enter your choice:");
         
         String choice = reader.next();
         
         LinkedList<BikePart> blank = new LinkedList<BikePart>();
         
//CALL WHICHEVER METHOD THE READER CHOSE. LOOP UNTIL QUIT IS CHOSEN        
         switch(choice.toUpperCase()){
            case "READ":
               bikeLL = ReadInventory.readInventory(bikeLL, reader);              
               break;

            case "ENTER":
               EnterSellDisplay.enterPart(reader);
                break;                          
            
            case "SELL":
               EnterSellDisplay.sellPart(reader);
               break;
 
            case "DISPLAY":
               EnterSellDisplay.displayPart(reader);
               break;
 	    
	         case "SORTNAME":
               SortNameNumber.sortNameNumber(choice, reader);
               break;

            case "SORTNUMBER":
               SortNameNumber.sortNameNumber(choice, reader);
               break;
               
            case "CREATEVAN":
               System.out.println("Enter the name of the new van:");
               String nm = reader.next();
               Writer.Write(nm, blank);
 
            case "QUIT":
               System.out.println("Thank you!");
               loop = false;
               break;               

            default:
               //NONE OF THESE WERE CHOSEN
               System.out.println("Please enter a valid command \n\n");
               break;
            }
         }         
      //USE THE WRITER CLASS TO WRITE THE LINKEDLIST TO A FILE     
      Writer.Write(warehouseFileName, bikeLL);
      reader.close();        
   }
}
