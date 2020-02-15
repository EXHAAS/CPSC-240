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
 * CPSC 240 Project 1 Writer Class 
 *
 * @author Hayden Webb
 * @version (a version number or a date)
 */
public class Writer
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Writer
     */
    public static void Write(String outputDirectory, LinkedList<BikePart> items) throws IOException
    //We discussed using LinkedList, but can be changed to ArrayList if better
    {
     
     PrintWriter out = new PrintWriter(outputDirectory);
     
     ListIterator<BikePart> itemsIt = items.listIterator();
     
     BikePart currentPart;
     String output;
     //itemsIt[0];
     int flag = 0;
     int aqq = 0;
     
     
      
      FileInputStream fileIn= new FileInputStream(outputDirectory);
      
      Scanner scnr = new Scanner(fileIn); //Basic Scanner
      //System.out.println(itemsIt.next());
      try { //try block to check for end of file
        while (flag == 0) {
         //
         currentPart = itemsIt.next();
         
         //output = (currentPart.getNumber() + "," +);
         out.println(currentPart.getName() + "," + currentPart.getNumber() + "," + currentPart.getListPrice() + "," + currentPart.getSalesPrice() + "," + currentPart.getOnSale() + "," + currentPart.getQuantity());
        // out.print(currentPart.getListPrice());
         //out.print(currentPart.getListPrice());
         //out.println(itemsIt.next().getNumber());
         aqq = aqq + 1;
        }
        //out.println(items.last);
        
     
         }   
       catch (java.util.NoSuchElementException exception){
        flag = 1; //end loop
        
    }      //catch block to check for end of file
        out.flush();
    
        fileIn.close();
      //System.out.println(items);//--InternalTesting--
      //System.out.println("FileGood");//--InternalTesting--
      
    }
     
}


