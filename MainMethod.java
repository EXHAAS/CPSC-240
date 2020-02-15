//THE MAIN METHOD FOR PROJECT 1

import java.util.Scanner;
import java.util.LinkedList;
public class MainMethod{
   public static void main(String[] args){
      Scanner reader = new Scanner(System.in);
      boolean loop = true;
//CALL SOME METHOD TO GET THE LINKEDLIST FROM THE INVENTORY FILE SO IT CAN SEND IT
//TO ALL THE SEPERATE METHODS
      //LinkedList inventory = //WHATEVER METHOD I CALL TO GET THE LIST
      
      while(loop == true){
//PRINT THE USERS CHOICES, THEN LET THEM ENTER THEIR CHOICE
         System.out.println("Please select your option from the following menu:");
         System.out.println("Read: Read an inventory delivery file");
         System.out.println("Enter: Enter a part");
         System.out.println("Sell: Sell a part");
         System.out.println("Display: Display a part");
         System.out.println("SortName: Sort parts by part name");
         System.out.println("SortNumber: Sort parts by part number");
         System.out.println("Quit:");
         System.out.println("Enter your choice:");
         
         String choice = reader.next();
         
//RUNNING AN INFINITE LOOP RIGHT NOW. OOF. LEARN TO FIX. CREATE ANOTHER METHOD
//TO BE CALLED AFTER CHOICE METHOD TO 
         switch(choice.toUpperCase()){
            case "READ":
               System.out.println("You want to read a file!");
               break;
            case "ENTER":
               //enterPart(reader, inventory);
               System.out.println("You want to enter a part!");
               break;
            case "SELL":
               //sellPart(reader, inventory);
               System.out.println("You want to sell a part!");
               break;
            case "DISPLAY":
               //displayPart(reader, inventory);
               System.out.println("You want to display a part!");
               break;
            case "SORTNAME":
               //CALL THE SORTNAME METHOD
               System.out.println("You want to sort by name!");
               break;
            case "SORTNUMBER":
               //CALL THE SORTNUMBER METHOD
               System.out.println("You want to sort by number!");
               break;
            case "QUIT":
               //CALL THE QUIT METHOD
               System.out.println("You want to quit!");
               loop = false;
               break;               
            default:
               //NONE OF THESE WERE CHOSEN
               System.out.println("You entered invalid information");
               loop = false;
               break;
            }
         }         
         //USE THE WRITER CLASS TO WRITE THE LINKEDLIST TO A FILE     
   }
}