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
      
      accounts = (Accounts.Employees());
      
    //SalesAssociate x = new SalesAssociate("Bob","Bobby","email","user","pass","S.txt"); // Account for testing
    //SystemAdministrator s = new SystemAdministrator("Bob","Bobby","email","user2","pass2");  
    //accounts.add(x);
    //accounts.add(s);   
      Employee ac = null;
      while(running == true) 
      {
      
      while(again == true) 
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
      }
      if(!loggedIn) {
    	  System.out.println("Incorrect login details.");
      }
      
      }  
      while(loggedIn == true){
    	//PRINT THE USERS CHOICES, THEN LET THEM ENTER THEIR CHOICE
          System.out.println("\nhello " + ac.getFirstName() + " " + ac.getLastName()+ "\n");
    	  
    	  if(ac.getType() == 1) {
   
    	  System.out.println("Please select your option from the following menu:");
    	  System.out.println("Create: Create new account");
          System.out.println("Logout: Sign off");
    	  System.out.println("Quit:");
    	  System.out.println("Enter your choice:");
    	  
    	  }
    	  if(ac.getType() == 2) {
        	  
    	  System.out.println("Please select your option from the following menu:");
    	  System.out.println("Display: Display a part");
    	  System.out.println("SortName: Sort parts by part name");
          System.out.println("SortNumber: Sort parts by part number");
    	  System.out.println("Logout: Sign off");
    	  System.out.println("Quit:");
    	  System.out.println("Enter your choice:");
    	  
    	  }
    	  if(ac.getType() == 3) {
    	  
    	  System.out.println("Please select your option from the following menu:");
    	  System.out.println("Read: Read an inventory delivery file");
    	  System.out.println("Display: Display a part");
    	  System.out.println("SortName: Sort parts by part name");
          System.out.println("SortNumber: Sort parts by part number");
          System.out.println("Logout: Sign off");
	      System.out.println("Quit:");
	      System.out.println("Enter your choice:");

    	  }
		  if(ac.getType() == 4) {
	      
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
               if(ac.getType()==3) 
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
               if(ac.getType()==4) 
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
            	if(ac.getType()==3 || ac.getType()==2) 
            	{
            		EnterSellDisplay.displayPart(reader);
            	}
            	else 
                {
            		System.out.println("Invalid Command");
                }
               break;
 	    
	         case "SORTNAME":
               if(ac.getType()==3 || ac.getType()==2) 
               {
	           SortNameNumber.sortNameNumber(choice, reader);
               }
               else 
               {
            	   System.out.println("Invalid Command");
               }
               break;

            case "SORTNUMBER":
            	if(ac.getType()==3 || ac.getType()==2) 
                {
 	           SortNameNumber.sortNameNumber(choice, reader);
                }
                else 
                {
             	   System.out.println("Invalid Command");
                }
               break;
               
            case "CREATE":
            	
            	if(ac.getType()==1) 
            	{
            		
            		Boolean taken = true;
            	        System.out.println("Enter First Name:");
            		String fn = reader.next();          		
            		System.out.println("Enter Last Name:");
            		String ln = reader.next();            		
            		System.out.println("Enter Email:");
            		String e = reader.next();            		
            		String u = null;
            		System.out.println("Enter Username:");
            		while(taken) 
            		{
            		int count = 0;
            		u = reader.next();
            		for(Employee acc:accounts) 
            		{
            			if(acc.getUsername().equals(u)) 
            			{
            				System.out.println("\nThat username is taken\nEnter Username:\n");
            				count += 1;
            			}
            		}
            		if(count == 0) 
            		{
            			taken = false;
            		}
            		
            		}
            		
            		System.out.println("Enter Password:");
            		String p = reader.next();
            		
            		System.out.println("Enter:\n1: New System Administrator\n2: New Office Manager\n3: New Warehouse Manager\n4: New Sales Associate");
            	    int na = reader.nextInt();
            	
            	
            	if(na==1) 
            	{           		
            		accounts.add(new SystemAdministrator(fn,ln,e,u,p));
            		System.out.println("Account Creation Successful");            		
            	}
            	else if(na==2) 
            	{           	
            		accounts.add(new OfficeManager(fn,ln,e,u,p));
            		System.out.println("Account Creation Successful");
            	}
            	else if(na==3) 
            	{
            		accounts.add(new WarehouseManager(fn,ln,e,u,p));
            		System.out.println("Account Creation Successful");
            	}
            	else if(na==4) 
            	{
            		System.out.println("Enter Van Name");
            		String v = reader.next();            		
            		accounts.add(new SalesAssociate(fn,ln,e,u,p,v));
            		System.out.println("Account Creation Successful\n");
            		Writer.Write(v, blank);
                    Fleet.FleetAdd(v);
                    System.out.println("New Van Established\n\n");
            	}
            	else 
            	{
            		System.out.println("Invalid Input");
            	}
            	}
                  	
            	else 
            	{
            		 System.out.println("Invalid Command");
            	}
         		
            	break;
            
             case "LOADINVENTORY":
                if(ac.getType()==4) 
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
      Accounts.writeAccount(accounts);
   }
}
