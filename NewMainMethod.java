/*THE MAIN METHOD FOR PROJECT 3
*
*I hereby declare upon my word of honor that I have neither given nor received
*unauthorized help on this work
*
*@author Ellie Haas
*@author Hayden Webb
*@author Anthony Tompkins
*/

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class NewMainMethod{
	public static void main(String[] args)throws IOException{
	  String warehouseFileName = "warehouseDB.txt";

	  LinkedList<BikePart> bikeLL = Importer.Import(warehouseFileName, 0);
	  LinkedList<BikePart> totalInvLL = Importer.Import("totalinventory.txt", 0);
	  
	  Scanner reader = new Scanner(System.in);
     
//USE LOGIN METHOD TO RETURN A USER ACCOUNT, SET THAT AS THE USER
      Employee user = Login();//EDIT WHEN LOGIN METHOD IS AVAILABLE 
      
//INCLUDE QUIT METHODS AND ACTUAL METHODS TO DO THINGS
      if(//LOGIN ACCOUNT IS A SYSTEM ADMIN){
         System.out.println("Welcome. Please select an option:");
         System.out.println("Create: Create a new account");
         //VARIOUS OTHER METHODS THAT MAY OR MAY NOT BE ADDED
         
      }else if(//LOGIN ACCOUNT IS AN OFFICE MANAGER){
         System.out.println("Welcome. Please select an option:");
         System.out.println("Examine: Look at a parts information");
         
      }else if(//LOGIN ACCOUNT IS A WAREHOUSE MANAGER){
         System.out.println("Welcome. Please select an option:");
         System.out.println("Update: Update the warehouse list");
         System.out.println("Examine: Look at a parts information");
         
      }else if(//LOGIN ACCOUNT IS A SALES ASSOSIATE){
         System.out.println("Welcome. Please select an option:");
         System.out.println("Load: Add inventory to your sales van");
         System.out.println("Invoice: Choose parts to sell");
      }else{
         System.out.println("That's not a valid account");
      }
                 
   }
}