/*THE METHOD TO ENTER A PART MANUALLY, SELL A PART, AND DISPLAY A PART
*I hereby declare upon my word of honor that I have neither given nor recieved
*unauthorized help on this work
*
*@author Ellie Haas
*/

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EnterSellDisplay{
   /*public static void main(String[] args){
      Scanner reader = new Scanner(System.in);
      
      LinkedList<BikePart> tester = new LinkedList<BikePart>();
      BikePart bp1 = new BikePart("WTB_saddle", 1234567890L, 33.00, 25.58, false, 5);
      BikePart bp2 = new BikePart("26inTube", 1234567891L, 7.00, 5.58, true, 20);
      BikePart bp3 = new BikePart("seatPost", 1234567892L, 17.00, 15.21, true, 300);
      BikePart bp4 = new BikePart("carbonHandleBars42cm", 1234567893L, 47.00, 5.58, false, 8);
      BikePart bp5 = new BikePart("frontTire", 1738495820L, 23.00, 20.00, false, 50);
      BikePart bp6 = new BikePart("leftPedal", 1738597039L, 14.80, 23.00, true, 34);
      BikePart bp7 = new BikePart("bikeRack", 2729475067L, 50.00, 45.00, true, 67);
      
      tester.add(bp1);
      tester.add(bp2);
      tester.add(bp3);
      tester.add(bp4);
      tester.add(bp5);
      tester.add(bp6);
      tester.add(bp7);
      
      enterPart(reader, tester);
      sellPart(reader, tester);
      //displayPart(reader, tester);
      
      for(BikePart part : tester){
         part.printInfo();
      }
   }*/
   
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
   
   public static void enterPart(Scanner s, LinkedList l){
      System.out.println("Enter the part's name:");
      String name = s.next();
      System.out.println("How many are there?");
      int quantity = s.nextInt();
      
      BikePart temp = searchBikePartList(l, name);
      if(temp != null){
         System.out.println("The part was already in the system.");
         int var1 = temp.getQuantity();
         temp.setQuantity(var1 + quantity);
      }else{            
         System.out.println("Enter the part's number:");
         long number = s.nextLong();
         System.out.println("Enter the part's list price:");
         double lPrice = s.nextDouble();
         System.out.println("Enter the part's sales price:");
         double sPrice = s.nextDouble();
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
   public static void sellPart(Scanner s, LinkedList l){
      System.out.println("Enter the part's number: ");
      long number = s.nextLong();
      
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
*@param l The inventory LinkedList being searched throuh
*/
   public static void displayPart(Scanner s, LinkedList l){
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
*I hereby declare upon my word of honor that I have neither given nor recieved
*unauthorized help on this work.
*
*  @author  Anthony Tompkins
*/

/**
 *
 *This is a method that takes a LinkedList of BikePart objects and a number corresponding to the number field of 
 *a BikePart in the given LinkedList. It iterates through the LinkedList and returns the BikePart whos's part number field 
 *is equal to the given string.
 *
 * @param bPLinkedList This parameter is the LinkedList that is being searched through.
 * @param bPNumber This parameter is the part number of the BikePart that is being looked for.
 * @return Returns BikePart named "part".
 */
	public static BikePart searchBikePartList(LinkedList<BikePart> bPLinkedList, long bPNumber)
	{
		BikePart part = null;
 		
		for (BikePart currentPart : bPLinkedList) 
		
		{
			if (currentPart.getNumber() == bPNumber) 
			{
				 part = currentPart;
				
			}

		}
		return part;
  } 
/**
 *
 *This is a method that takes a LinkedList of BikePart objects and a name corresponding to the name field of 
 *a BikePart in the given LinkedList. It iterates through the LinkedList and returns the BikePart whos's part name field 
 *is equal to the given string.
 *
 * @param bPLinkedList This parameter is the LinkedList that is being searched through.
 * @param bPName This parameter is the part number of the BikePart that is being looked for.
 * @return Returns BikePart named "part".
 */
	public static BikePart searchBikePartList(LinkedList<BikePart> bPLinkedList, String bPName)
	{
		BikePart part = null;
 		
		for (BikePart currentPart : bPLinkedList) 
		
		{
			if (currentPart.getName().equals(bPName)) 
			{
				 part = currentPart;
				
			}

		}
		return part;
  } 
  
}