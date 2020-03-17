import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.ListIterator;
/**
 * CPSC 240 Project 2 Van Class 
 *
 * @author Hayden Webb
 * @version (a version number or a date)
 */
public class Van
{
    
    
    public static int Transfer(String vanDirectory, String warDirectory, BikePart bikePart) throws IOException
    
    {
      
      
      
      //Used for both transferring files to van from war, and to war from van
      
      
      
      
      LinkedList<BikePart> partToMove = new LinkedList<BikePart>();
      LinkedList<BikePart> warehouse = new LinkedList<BikePart>();
      
      Importer read = new Importer();
      
      warehouse = read.Import(warDirectory,0);
      ListIterator<BikePart> bikePartConfirm = warehouse.listIterator();
        
        
        int flag = 0;
        int aqq = 0;
    try {
        while (flag == 0) {
         if (bikePartConfirm.next().getName().equals( bikePart.getName())) {
             flag = 2; //confirm part exists
             bikePartConfirm.remove();  //Remove bikePart from Warehouse
             //System.out.println("QVV");
            }
         //bikePartConfirm.next();
         //System.out.println("AA");
        }
    }
    catch (java.util.NoSuchElementException exception){
      flag = 1; //end loop  
    }
    
      if (flag == 2 ) {
      //warehouse.remove(bikePart);
      
      
      partToMove = read.Import(vanDirectory,0); 
      partToMove.addLast(bikePart);
      
      //System.out.println("Q2");
      
      // Overwrites whatever is in the van file, so this copies all data beforehand
                                                           
      Writer write = new Writer();
      write.Write(vanDirectory, partToMove); //Adds transferred part to van
      write.Write(warDirectory, warehouse); //Removes transferred part from warehouse
      
    }
      
      return flag;  
      //returns updated linked list with part removed
    }
    
    public static LinkedList<BikePart> ToWarehouse(LinkedList<BikePart> bikePartsMain, BikePart bikePart, String directory) throws IOException
    
    {
      
      
      bikePartsMain.remove(bikePart); //Removes transferred part from warehouse
      
      LinkedList<BikePart> partToMove = new LinkedList<BikePart>();
      
      Importer read = new Importer();
      partToMove = read.Import("directory1",0); 
      partToMove.addLast(bikePart);
      
      // Overwrites whatever is in the van file, so this copies all data beforehand
                                                           
      Writer write = new Writer();
      write.Write(directory, partToMove);
      
      
      
      return bikePartsMain;  
      //returns updated linked list with part removed
    }
    
    public static LinkedList<BikePart> ToVanOLD(LinkedList<BikePart> bikePartsMain, BikePart bikePart, String directory) throws IOException
    
    {
      
      
      
      
      bikePartsMain.remove(bikePart); //Removes transferred part from warehouse
      
      
      
      LinkedList<BikePart> partToMove = new LinkedList<BikePart>();
      
      Importer read = new Importer();
      partToMove = read.Import(directory,0); 
      partToMove.addLast(bikePart);
      
      // Overwrites whatever is in the van file, so this copies all data beforehand
                                                           
      Writer write = new Writer();
      write.Write(directory, partToMove);
      
      
      
      return bikePartsMain;  
      //returns updated linked list with part removed
    }
    
/*Allows the user to select a warehouse/van file that will have inventory
*moved FROM it. Loops through the list until the user has selected all the
*parts they wish to move.
*
*@author Eleanor Haas
*@param fileName The name of the file the inventory is taken from
*@return A LinkedList of BikeParts to be moved to the chosen location
*/
   public static LinkedList<BikePart> chooseParts(String fileName, Scanner s) throws IOException{      
      LinkedList<BikePart> houseList = Importer.Import(fileName, 1);
      LinkedList<BikePart> toMove = new LinkedList<BikePart>();
      boolean cont = true;

      while(cont == true){
         System.out.println("What inventory would you like to move?\n\n");      
         ListIterator list = houseList.listIterator(0);
         while(list.hasNext()){
            BikePart part = (BikePart)list.next();
            System.out.println(part.getName() + " " + part.getQuantity());
         }
         
         
         System.out.println("Enter the name of the part: ");
         String name = s.next();
         
         BikePart temp = SearchBikePartList.searchBikePartList(houseList, name);
            
         if(temp == null){
            System.out.println("You have entered an invalid part");
         }else{
            boolean cont2 = true;
            while(cont2 == true){
               System.out.println("There are " + temp.getQuantity() + " parts in this warehouse.");
               System.out.println("How many would you like to move? Enter the number:");
               int num = s.nextInt();
               
               if(num > temp.getQuantity()){
                  System.out.println("You have selected more parts then there are.");
                  System.out.println("Please try again\n\n");
               }else if(num == temp.getQuantity()){
                  System.out.println("You have chosen to move all the parts");
                  toMove.add(temp);
                  temp.setQuantity(0);
                  cont2 = false;
               }else{
                  int dif = temp.getQuantity() - num;
                  temp.setQuantity(num);
                  toMove.add(temp);
                  temp.setQuantity(dif);
                  cont2 = false;
               }
            }
         }
         System.out.println("If you are done selecting parts, enter \"exit\", else enter anything");
         String ans = s.next();
         
         if(ans.equalsIgnoreCase("exit")){
            cont = false;
         }
      }
      Writer.Write(fileName, houseList);
      return toMove;
   }
}
