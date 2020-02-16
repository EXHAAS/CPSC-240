/*THE METHOD TO ENTER A PART MANUALLY, SELL A PART, AND DISPLAY A PART
*I hereby declare upon my word of honor that I have neither given nor received
*unauthorized help on this work
*
*@author Ellie Haas
*/

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Date;
import java.text.SimpleDateFormat;
public class EnterSellDisplay{
//   public static void main(String[] args){        
//      enterPart(reader, tester);   
//      sellPart(reader, tester);
//      displayPart(reader, tester);     
//      for(BikePart part : tester){
//        part.printInfo();
//       }
//   }
   
/*
*Designed for the user to manually enter a part. Asks the user for the name and 
*quantity of the part they wish to enter, then searches through the inventory list
*to see if the part is already there. If it is, then the quantity of the part is 
*increased by the quantity they entered. If it is not, the system prompts for the 
*rest of the information then adds it to the end of the LinkedList.
*
*@param s The Scanner passed in from the main method
*@param l The inventory LinkedList that's searched/added to
*/
	
	

      public static void enterPart(Scanner s, LinkedList<BikePart> l){
      System.out.println("Enter the part's name:");
      String name = s.next();
      System.out.println("How many are there?");
      
      String quantityString = s.next();
// When flag is equal to 1 the user input is checked to see if it is an integer.
      int flag = 1;
      String qInput = inputCheck(quantityString, flag);
      if(qInput == null) {
      System.out.println("Invalid Input \n\n");
    	return;
      }
      int quantity = Integer.parseInt(quantityString);
      BikePart temp = searchBikePartList(l, name);
      if(temp != null){
         System.out.println("The part was already in the system.");
         int var1 = temp.getQuantity();
         temp.setQuantity(var1 + quantity);
      }else{            
         System.out.println("Enter the part's number:");
         String number = s.next();
         System.out.println("Enter the part's list price:");
 // When flag is equal to 2 the user input is checked to see if it is an integer.        
         flag = 2;
         String lPriceString = s.next();
         String lPInput = inputCheck(lPriceString, flag);
         if(lPInput == null) {
             System.out.println("Invalid Input \n\n");
           	return;
             }
         double lPrice = Double.parseDouble(lPriceString);
         System.out.println("Enter the part's sales price:");
         
         
         String sPriceString = s.next();
         String sPInput = inputCheck(lPriceString, flag);
         if(sPInput == null) {
             System.out.println("Invalid Input \n\n");
           	return;
             }
         double sPrice = Double.parseDouble(sPriceString);
         System.out.println("Is the part on sale? y/n");
         
         String ans = s.next();
        
         boolean sale;
            if(ans.equalsIgnoreCase("y")){
               sale = true;
            }else if(ans.equalsIgnoreCase("n")){
               sale = false;
            }else{
               System.out.println("You entered an invalid response. It is assumed " +
               "that the part is not on sale.");
               sale = false;
            }            
         
         BikePart part = new BikePart(name, number, lPrice, sPrice, sale, quantity);
         l.add(part);
         System.out.println("The part has been sucessfully added!");
      }  
      }
      
      
 
/*
*Designed to sell the user a part. The user inputs the number of the part, then the
*system searches through the list to see if it's there. If it is, then the price of
*the part (either list or sale) is displayed along with the name and the time and
*date of the sale.
*
*@param s The Scanner passed in from the main method
*@param l The inventory LinkedList being searched through
*/ 
   public static void sellPart(Scanner s, LinkedList<BikePart> l){
      System.out.println("Enter the part's number: ");
      String number = s.next();
      
      BikePart temp = searchBikePartList(l, number);
      if(temp != null){
         System.out.println(temp.getName());
         temp.setQuantity(temp.getQuantity() - 1);
         if(temp.getOnSale() == true){
            System.out.println(temp.getSalesPrice());
            System.out.println("This part is on sale.");
         }else{
            System.out.println(temp.getListPrice());
            System.out.println("This part is not on sale.");
         }
      }else{
         System.out.println("This part was not in the system.");
      }
      
      Date time = new Date();
      SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
      System.out.println(form.format(time));    
   }
   
/* 
*Designed to display the information of a part. The user inputs the part's name and
*the system searches the list. If the part is in the list the name, price, and if 
*the part is on sale or not is printed. If the part is not in the system, then the
*system prints that it isn't there.
*
*@param s The Scanner passed in from the main method 
*@param l The inventory LinkedList being searched through
*/
   public static void displayPart(Scanner s, LinkedList<BikePart> l){
      System.out.println("Enter the name of the part:");
      String name = s.next();
      
      BikePart temp = searchBikePartList(l, name);
      if(temp != null){
         System.out.println("The name is: " + temp.getName());
         if(temp.getOnSale() == true){
            System.out.println("The price is: " + temp.getSalesPrice());
         }else{
            System.out.println("The price is: " + temp.getListPrice());
         }
      }else{
         System.out.println("The part is not in the system.");
      }
   }   
   
/**
* 
* *CPSC-240
*I hereby declare upon my word of honor that I have neither given nor received
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
  

/**
 * Method to check if user input is valid.
 * @param userInput The user's input as a string.
 * @param flag integer variable to tell if userInput should be treated as an integer or double. 1 = integer 2 = double
 * @return returns string which can either point to null or have the value of userInput.
 */
	public static String inputCheck(String userInput, int flag) 
	{
// invalid variable keeps track if a character in userInput was found to not be in numberString. 
		int invalid = 0;
// input variable is a string that is returned.
		String input = null;
// numberString is a string that holds numbers.
		String numberString = null;
// if flag is equal to 1 the userInput is checked to see if it is possible to be converted into an integer, or a double if flag
// equals 2.
		if(flag == 1) 
		{
			numberString = "1234567890";
		}
		else if(flag == 2) 
		{
			numberString = "1234567890.";
		}
// A char[] of userInput is made.	
		char[] inputCharArray = userInput.toCharArray();
// Loop were if a character does not occur in numberString the test is set assigned the value of -1 and invalid is incremented by 1. 
		for(char c: inputCharArray)
		{
			int test = numberString.indexOf(c);
			if(test < 0) 
			{
			invalid++;
			}
		
		}
// input is assigned the value of userInput if invalid is equal to 0.
		if(invalid == 0) 
		{
		input = userInput;
		}
		return input;
	}
}
