/*THE MAIN METHOD FOR PROJECT 1
*
*I hereby declare upon my word of honor that I have neither given nor received
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
	  LinkedList<BikePart> totalInvLL = Importer.Import("totalinventory.txt", 0);
	  
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
          System.out.println("MoveInventory: Move BikeParts around warehouses");
          System.out.println("Quit:");
          System.out.println("Enter your choice:");
          
          String choice = reader.next();
          
          LinkedList<BikePart> blank = new LinkedList<BikePart>();
          
 //CALL WHICHEVER METHOD THE READER CHOSE. LOOP UNTIL QUIT IS CHOSEN           
         switch(choice.toUpperCase()){
            case "READ":
               totalInvLL = ReadInventory.readInventory(bikeLL, totalInvLL,reader);              
               Writer.Write("totalinventory.txt", totalInvLL);
               break;

            case "ENTER":
               totalInvLL = EnterSellDisplay.enterPart(reader,totalInvLL);
               Writer.Write("totalinventory.txt", totalInvLL);
               break;                          
            
            case "SELL":
               totalInvLL = EnterSellDisplay.sellPart(reader,totalInvLL);
               Writer.Write("totalinventory.txt", totalInvLL);
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
                Fleet.FleetAdd(nm);
                System.out.println("Your van has been created\n\n");
                break;
                
             case "MOVEINVENTORY":
                Fleet.printFleet();
                System.out.println("warehouseDB.txt");
                System.out.println("Which file would you like to move from?");
                String moveFile = reader.next();
                LinkedList<BikePart> move = Van.chooseParts(moveFile, reader);

                Fleet.printFleet();
                System.out.println("warehouseDB.txt");
                System.out.println("Which file would you like to move to?");
                String toFile = reader.next();
                
                Van.editFile(toFile, move);
                System.out.println("Your inventory has been moved\n\n");
                break;
  
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
      
      
      reader.close();        
   }
}
