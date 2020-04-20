/*THE METHOD TO ENTER A PART MANUALLY, SELL A PART, AND DISPLAY A PART
*I hereby declare upon my word of honor that I have neither given nor received
*unauthorized help on this work
*
*@author Ellie Haas
*@author Anthony Tompkins
*/

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class EnterSellDisplay{
	
/*
*Designed to sell the user a part. The user inputs the number of the part, then the
*system searches through the list to see if it's there. If it is, then the price of
*the part (either list or sale) is displayed along with the name and the time and
*date of the sale.
*
*@param s The Scanner passed in from the main method
*@param totalInvLL The LinkedList of BikeParts from the complete inventory
*@param ac Employee account passed from MainMethod
*@return Return LinkedList of BikeParts to be used to update the total inventory
*/ 
   public static LinkedList<BikePart> sellPart(Scanner s, LinkedList<BikePart> totalInvLL, Employee ac) throws IOException{
	   // String to format total in invoices
	   // Used to append new invoices to Invoice.txt file
	   FileWriter invoiceWriter = new FileWriter("Invoices.txt",true);
	   s.nextLine();
	   Date time = new Date();
       SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss\n\n");
       SalesAssociate sa = (SalesAssociate)ac;
       // Keeps track of final total of the transaction
       double finalTotal = 0;
       String whName = sa.getVan();
       System.out.println();  
	  
       System.out.println("Enter the name of the bike shop");
	   String shopName = s.nextLine();
	   System.out.println("Enter the client's name");
	   String client = s.nextLine();
	   
	   String date = form.format(time).toString();
	   
	   String invoice =  "Sales Associate: " + sa.getFirstName() + " " + sa.getLastName() + "\n" 
	   + "Sales Invoice for " + shopName + " " + date + "\nName                   Number                 Price                 Sale Price            Sold                  Total\n" ;
	  
	   
                  
      LinkedList<BikePart> houseList = Importer.Import(whName, 1);
      
      // Creates new Invoices.txt file if one does no exist
          File invFile = new File("Invoices.txt");
          invFile.createNewFile();
          
      // Boolean to keep track if more items are to be sold  
      boolean cont = true;
      // Boolean to keep track if a new invoice was made
      boolean invoiceMade = false;
      while(cont == true)
      {
         System.out.println("Current Inventory:\n");      
         ListIterator<BikePart> list = houseList.listIterator(0);
         //Iterates through list of parts and prints their name, number, and quantity
         while(list.hasNext())
         {
            BikePart part = (BikePart)list.next();
            System.out.println(part.getName() + ", " + part.getNumber() + " Quantity: " + part.getQuantity());
         }
         
         
         System.out.println("Enter part name or number: ");
         String name = s.nextLine();
         
         BikePart temp = SearchBikePartList.searchBikePartList(houseList, name);
         BikePart toBP = SearchBikePartList.searchBikePartList(totalInvLL, name);
            
         if(temp == null)
         {
            System.out.println("You have entered an invalid part");
         }
         else
         {
            boolean cont2 = true;
            while(cont2 == true){
               System.out.println("There are " + temp.getQuantity() + " parts in this warehouse.");
               System.out.println("How many part are being sold?:");
               int num = s.nextInt();
        	   s.nextLine();

               String sNum = Integer.toString(num);
               if(num > temp.getQuantity()){
                  System.out.println("You have selected more parts then there are.");
                  System.out.println("Please try again\n\n");
               }
               else if(num == temp.getQuantity())
               {
                  System.out.println("All " + temp.getName() + "'s" + " have been sold");
                  if(temp.getOnSale()) 
                  {
                  
                  double total = temp.getSalesPrice() * num;
                  finalTotal += total;
                  String totalS = String.format("%.2f", total);                
                  String invoiceFormat = "%-22s %-22s %-22s %-22s %-19s %-22s";
                  if(!invoiceMade) 
                  {
                	  invoiceWriter.write(invoice);
                	  invoiceMade = true;
                  }
                  invoiceWriter.write(String.format(invoiceFormat, temp.getName(), temp.getNumber(), "$" + String.format("%.2f",temp.getListPrice()), "$" + String.format("%.2f", temp.getSalesPrice()), sNum, "$" + totalS));
                  invoiceWriter.write("\n");
              
                  }
                  else 
                  {
                	  double total = temp.getListPrice() * num;
                      finalTotal += total;
                	  String totalS = String.format("%.2f", total);                

                	  String invoiceFormat = "%-22s %-22s %-22s %-22s %-19s %-22s";
                      if(!invoiceMade) 
                      {
                    	  invoiceWriter.write(invoice);
                    	  invoiceMade = true;
                      }
                      invoiceWriter.write(String.format(invoiceFormat, temp.getName(), temp.getNumber(), "$" + String.format("%.2f",temp.getListPrice()), "$" + String.format("%.2f", temp.getSalesPrice()), sNum, "$" + totalS));
                      invoiceWriter.write("\n");
                  
                  }
                  
                  houseList.remove(temp);
                  
                  if(toBP.getQuantity() == num) {
                	  totalInvLL.remove(toBP);
                  }
                  else
                  {
                	  toBP.setQuantity(toBP.getQuantity() - num);
                  }
                  
                  cont2 = false;
               }
            else
            {
            	if(temp.getOnSale()) 
                {
                
                double total = temp.getSalesPrice() * num;
                
                finalTotal += total;
                String totalS = String.format("%.2f", total);
                String invoiceFormat = "%-22s %-22s %-22s %-22s %-19s %-22s";
                if(!invoiceMade) 
                {
              	  invoiceWriter.write(invoice);
              	  invoiceMade = true;
                }
                invoiceWriter.write(String.format(invoiceFormat, temp.getName(), temp.getNumber(), "$" + String.format("%.2f",temp.getListPrice()) , "$" + String.format("%.2f", temp.getSalesPrice()), sNum, "$" + totalS));
                invoiceWriter.write("\n");
                }
                else 
                {
              	    double total = temp.getListPrice() * num;
              	    finalTotal += total;  
              	    String totalS = String.format("%.2f", total);                
                    String invoiceFormat = "%-22s %-22s %-22s %-22s %-19s %-22s";
                    if(!invoiceMade) 
                    {
                  	  invoiceWriter.write(invoice);
                  	  invoiceMade = true;
                    }
                    invoiceWriter.write(String.format(invoiceFormat, temp.getName(), temp.getNumber(), "$" + String.format("%.2f", temp.getListPrice()), "$" + String.format("%.2f", temp.getSalesPrice()), sNum,  "$" + totalS));
                    invoiceWriter.write("\n");
                }
            	  int dif = temp.getQuantity() - num;

                  temp.setQuantity(dif);
                  toBP.setQuantity(toBP.getQuantity() - num);
                  cont2 = false;
               }
            }
         }
         System.out.println("If the transaction is complete, enter \"exit\", else enter anything");
         String ans = s.next();
  	     s.nextLine();

         if(ans.equalsIgnoreCase("exit")){
            cont = false;
            if(invoiceMade) 
            {
            	String finalTotalS = String.format("%.2f", finalTotal);
            	String form2 = "%-112s";
            	invoiceWriter.write(String.format(form2, "Total:") + "$" + finalTotalS + "\n\nReceived by: " + client +"\n\n\n");
            }
            invoiceWriter.close();
           
         }
      }                
         
    Writer.Write(whName, houseList); 
	return totalInvLL;
     	
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
   public static void displayPart(Scanner s) throws IOException{
      System.out.println("Enter the name of the warehouse:");
      String whName = s.next();
      
      LinkedList<BikePart> houseList = Importer.Import(whName, 1);
      
      if(houseList.size() != 0){
         System.out.println("Enter the name of the part:");
         String name = s.next();
         
         BikePart temp = SearchBikePartList.searchBikePartList(houseList, name);
         
         if(temp != null){
            System.out.println("The name is: " + temp.getName());
            if(temp.getOnSale() == true){
               System.out.println("The price is: " + temp.getSalesPrice() + "\n\n");
            }else{
               System.out.println("The price is: " + temp.getListPrice() + "\n\n");
            }
         }else{
            System.out.println("The part is not in the system.\n\n");
         }
         
         Writer.Write(whName, houseList);
      }else{
         System.out.println("There was nothing there!\n\n");
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
