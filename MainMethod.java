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
	  
	  LinkedList<Employee> accounts = new LinkedList<Employee>();
	  
	  Scanner reader = new Scanner(System.in);
      
      // Boolean for keeping the program running
      boolean running = true;
      // Boolean to check if an account is signed in
      boolean loggedIn = false;
      // Boolean for signing in.
      boolean again = true;
      
 /*     SalesAssociate x = new SalesAssociate("Bob","Bobby","email","user","pass","S.txt"); // Account for testing
      
    accounts.add(x);
 */       
      Employee ac = null;
      while(running == true) 
      {
      
      while(again) 
      {
      System.out.println("Enter Username:");
      String username = reader.next();
      System.out.println("Enter Password:");
      String password = reader.next();
      
      for(Employee a:accounts) 
      {
      
      if(a.check(username, password)) 
      {
    	  ac = a;
    	  loggedIn =true;
    	  again = false;
      }
      
      if(!loggedIn) {
    	  System.out.println("Incorrect login details.");
      }
      }  
      }  
      while(loggedIn == true){
    	//PRINT THE USERS CHOICES, THEN LET THEM ENTER THEIR CHOICE
          System.out.println("\nhello " + ac.getFirstName() + " " + ac.getLastName()+ "\n");
    	  
    	  if(ac.getType().equals("SystemAdminstrator")) 
	  {
        	
    	  System.out.println("Please select your option from the following menu:");
    	  System.out.println("Logout: Sign off");
    	  System.out.println("Quit:");
    	  System.out.println("Enter your choice:");
    	  
    	  }
    	  if(ac.getType().equals("OfficeManager")) 
	  {
        	  
    	  System.out.println("Please select your option from the following menu:");
    	  System.out.println("Display: Display a part");
    	  System.out.println("SortName: Sort parts by part name");
          System.out.println("SortNumber: Sort parts by part number");
    	  System.out.println("Enter your choice:");
    	  System.out.println("Logout: Sign off");
    	  System.out.println("Quit:");
    	  
    	  }
    	  if(ac.getType().equals("WarehouseManager")) 
	  {
    	  
    	  System.out.println("Please select your option from the following menu:");
    	  System.out.println("Read: Read an inventory delivery file");
    	  System.out.println("Display: Display a part");
    	  System.out.println("SortName: Sort parts by part name");
          System.out.println("SortNumber: Sort parts by part number");
          System.out.println("Logout: Sign off");
	  System.out.println("Quit:");
	  System.out.println("Enter your choice:");

    	  }
	  if(ac.getType().equals("SalesAssociate")) 
	  {
	      
	  System.out.println("Please select your option from the following menu:");
	  System.out.println("Sell: Sell parts");
	  System.out.println("LoadInventory: Load new inventory");
	  System.out.println("Logout: Sign off");
	  System.out.println("Quit:");
	  System.out.println("Enter your choice:");
	      
	  }

          
          
 //         System.out.println("CreateVan: Create a new van for the fleet");

          
          String choice = reader.next();
          LinkedList<BikePart> blank = new LinkedList<BikePart>();
          
 //CALL WHICHEVER METHOD THE READER CHOSE. LOOP UNTIL QUIT IS CHOSEN           
         switch(choice.toUpperCase()){
            case "READ":  
               if(ac.getType().equals("WarehouseManager")) 
               {          	   
               totalInvLL = ReadInventory.readInventory(bikeLL, totalInvLL,reader);              
               Writer.Write("totalinventory.txt", totalInvLL);
               bikeLL = Importer.Import(warehouseFileName, 0);
               }
               else 
               {
            	   System.out.println("Invalid Command");
               }
	       break;

            case "SELL":
               if(ac.getType().equals("SalesAssociate")) 
               {
               totalInvLL = EnterSellDisplay.sellPart(reader,totalInvLL, ac);
               Writer.Write("totalinventory.txt", totalInvLL);
	           bikeLL = Importer.Import(warehouseFileName, 0);
               }
               else 
               {
            	   System.out.println("Invalid Command");
               }
               break;
 
            case "DISPLAY":
               EnterSellDisplay.displayPart(reader);
               break;
 	    
	         case "SORTNAME":
               if(ac.getType().equals("WarehouseManager") || ac.getType().equals("OfficeManager")) 
               {
	           SortNameNumber.sortNameNumber(choice, reader);
               }
               else 
               {
            	   System.out.println("Invalid Command");
               }
               break;

            case "SORTNUMBER":
            	if(ac.getType().equals("WarehouseManager") || ac.getType().equals("OfficeManager")) 
                {
 	           SortNameNumber.sortNameNumber(choice, reader);
                }
                else 
                {
             	   System.out.println("Invalid Command");
                }
               break;
               
            case "CREATEVAN":
                System.out.println("Enter the name of the new van:");
                String nm = reader.next();
                Writer.Write(nm, blank);
                Fleet.FleetAdd(nm);
                System.out.println("Your van has been created\n\n");
                break;
                
             case "LOADINVENTORY":
                if(ac.getType().equals("SalesAsscociate")) 
                {
            	Fleet.printFleet();
                System.out.println("warehouseDB.txt");
                System.out.println("Which warehouse are you receiving inventory from?");
                String moveFile = reader.next();
                LinkedList<BikePart> move = Van.chooseParts(moveFile, reader);

                Fleet.printFleet();
                System.out.println("warehouseDB.txt");
                System.out.println("Which file would you like to move to?");               
                String toFile = ((SalesAssociate) ac).getVan();
                
                Van.editFile(toFile, move);
                System.out.println("Your inventory has been moved\n\n");
                }
                else 
                {
             	   System.out.println("Invalid Command");
                }
                break;
  
             case "LOGOUT":
            	 
            	 System.out.println("Logout Successful");
            	 again = true;
            	 loggedIn = false;
            	 break;
             
             case "QUIT":
                System.out.println("Thank you!");
                running = false;
                loggedIn = false;
                break;               

             default:
                //NONE OF THESE WERE CHOSEN
                System.out.println("Please enter a valid command \n\n");
                break;
            }
         }         
      //USE THE WRITER CLASS TO WRITE THE LINKEDLIST TO A FILE     
      
      
         
      
   }
      reader.close();
   }
}
