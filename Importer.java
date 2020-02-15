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
 * CPSC 240 Project 1 Importer Class 
 *
 * @author Hayden Webb
 * @version (a version number or a date)
 */
public class Importer
{
    
    //LinkedList<String>
    public static LinkedList<BikePart> Import(String directory) throws IOException
    //We discussed using LinkedList, but can be changed to ArrayList if better
    {
      
      
      //String directory; //file that scnr reads from, warehouseDB.txt
      //directory = "warehouseDB.txt"; Typical default
      
      LinkedList<BikePart> items = new LinkedList<BikePart>(); //main parts list
                                                           //if no file or txt
      //needed for conversion                                                     //will return empty 
      String raw = " ";
      String[] rawList;
      
      BikePart part;
      long b1;
      double b2;
      double b3;
      boolean b4 = true;
      int b5;
      
      
      int flag = 0; //flag is used to determine what state something is in
                    //if flag = 0, there is still text to read and loop goes
                    //if flag = 1, end of the file is reached,and loop ends
      
      
      try {      //try block to check for file existing
      
      FileInputStream fileIn= new FileInputStream(directory);
      
      Scanner scnr = new Scanner(fileIn); //Basic Scanner
      

            
      try {      //try block to check for end of file
          
      while (flag == 0) {
         //items.addLast(scnr.nextLine()); 
         raw = scnr.nextLine();
         rawList = raw.split(",");
         b1 = (long) Double.parseDouble(rawList[1]);
         b2 = Double.parseDouble(rawList[2]);
         b3 = Double.parseDouble(rawList[3]);
         if (rawList[4].equals("false") || rawList[4].equals("False")){
        b4 = false;    
        }
         if (rawList[4].equals("true") || rawList[4].equals("True")){
        b4 = true;    
        }
        b5 = (int) Double.parseDouble(rawList[5]); 
        
         part = new BikePart(rawList[0],rawList[1],b2,b3,b4,b5); 
         items.addLast(part);
         
         //items.addLast()
         
         
          
        }
          
          
          
        }   
       catch (java.util.NoSuchElementException exception){
        flag = 1; //end loop
        
    }      //catch block to check for end of file
      fileIn.close();
      //System.out.println(items);//--InternalTesting--
      //System.out.println("FileGood");//--InternalTesting--
      
    }
    catch (java.io.FileNotFoundException exception){
      flag = writeEmptyFile (directory); //Will Create a blank new file
                                         //if file does not exist
      //System.out.println(items); //--InternalTesting--
      //System.out.println("CaughtNoFile"); //--InternalTesting--
    }      //catch block to check for file existing
      return items;  
      //items = list;
    }
    
    public static int writeEmptyFile (String directory) throws IOException
   {
     FileOutputStream fileOut= new FileOutputStream(directory);
     
     return 1;
     //Pretty much does as titled, creates a blank file when called upon
    }
    
}
